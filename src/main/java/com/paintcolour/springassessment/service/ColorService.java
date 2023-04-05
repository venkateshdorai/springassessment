package com.paintcolour.springassessment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paintcolour.springassessment.api.ColorNameMismatchException;
import com.paintcolour.springassessment.api.ColorNotFoundException;
import com.paintcolour.springassessment.api.InvalidParametersException;
import com.paintcolour.springassessment.model.Color;
import com.paintcolour.springassessment.repository.ColorDao;
import com.paintcolour.springassessment.repository.ColorRepository;

@Service
public class ColorService {
	
	@Autowired
	private ColorRepository colorRepository;
	
	@Autowired
	private ColorDao colorDao;

	public Color saveColor(Color color) {
		Color colorByName = colorRepository.findColorByName(color.getName());
		if(colorByName!=null) {
			throw new InvalidParametersException("Invalid Params");
		}
		return colorRepository.save(color);
	}
	
	public Color updateColor(Color color, String colorName) {
		Color tempColor = colorRepository.findColorByName(colorName);
		if(tempColor==null) {
			throw new ColorNotFoundException("Color Not Found");
		}
		if (!color.getName().equals(colorName)) {
	          throw new ColorNameMismatchException("Invalid ID supplied");
	    }
		return colorRepository.save(color);
	}

	public Color findColorByName(String colorName) {
		Color color = colorRepository.findColorByName(colorName);
		if(color==null) {
			throw new ColorNotFoundException("One or both colors could not be found");
		}
		return color;
	}
	
	public Optional<Color> findColorById(String colorName) {
		return colorRepository.findById(colorName);
	}

	public List<Color> findAllColors() {
		return colorRepository.findAll();
	}
	
	public void deleteColorByName(String colorName) {
		Color color = colorRepository.findColorByName(colorName);
		if(color==null) {
			throw new ColorNotFoundException("One or both colors could not be found");
		}
		colorRepository.deleteById(colorName);
	}

	public Color mixColor(String colorName1, String colorName2) {
		Color color1 = colorRepository.findColorByName(colorName1);
		if(color1==null) {
			throw new ColorNotFoundException("One or both colors could not be found");
		}
		Color color2 = colorRepository.findColorByName(colorName2);
		if(color2==null) {
			throw new ColorNotFoundException("One or both colors could not be found");
		}
		Integer r = color1.getRed()+color2.getRed();
		Integer g = color1.getGreen()+color2.getGreen();
		Integer b = color1.getBlue()+color2.getBlue();
		if(r>255 || r<0 || g>255 || g<0 || b>255 || b<0 ) {
			throw new InvalidParametersException("Invalid parameters supplied");
		}
		
		Color color =  colorDao.getMixedColor(r, g, b);
		return color;
	}
}
