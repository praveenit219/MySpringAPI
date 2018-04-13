/**
 * 
 */
package com.pheonix.services;

import java.util.List;

/**
 * @author praveentirunamali
 *
 */
public interface CRUDService<T> {
	
	List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);

}
