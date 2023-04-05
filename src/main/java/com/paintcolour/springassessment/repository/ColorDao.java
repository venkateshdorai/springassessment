package com.paintcolour.springassessment.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.paintcolour.springassessment.model.Color;

@Component
public class ColorDao {

	@PersistenceContext
    private EntityManager entityManager;

	public Color getMixedColor(Integer red, Integer green, Integer blue) {
		Query query =  entityManager.createNativeQuery("SELECT * FROM Color c where red=?1 and green=?2 and blue=?3");
		query.setParameter(1, red);
		query.setParameter(2, green);
		query.setParameter(3, blue);
		Color color = null;
		try {
		Object[] obj = (Object[]) query.getSingleResult();
		color = new Color(obj[0].toString(), red, green, blue);
		}catch(NoResultException e) {
			color = new Color(null, red, green, blue);
		}
		
		return color;
	}

}
