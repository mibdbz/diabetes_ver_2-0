package pl.mibdbz.diabetes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.mibdbz.diabetes.entity.Product;


@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getProducts() {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Product> theQuery = currentSession.createQuery("From Product order by name", Product.class);
		
		List<Product> products = theQuery.getResultList();
		
		return products;
	}

	@Override
	public void saveProduct(Product theProduct) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theProduct);
	}

	@Override
	public Product getProduct(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Product theProduct = currentSession.get(Product.class, theId);
		
		return theProduct;
	}

}
