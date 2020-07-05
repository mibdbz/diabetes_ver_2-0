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

	@Override
	public void deleteProduct(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Product where id=:productId");
		
		theQuery.setParameter("productId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Product> searchForProducts(String theSearchName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		if (theSearchName != null && theSearchName.trim().length() > 0) {
			
			theQuery = currentSession.createQuery("from Product where lower(name) like :theName", Product.class);
			
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
			
		} else {
            // theSearchName is empty ... so just get all customers
            theQuery = currentSession.createQuery("from Product order by name", Product.class);            
        }
		
		List<Product> products = theQuery.getResultList();
		
		if(products.isEmpty()) {
			
			Product theProduct = new Product();
			theProduct.setName("Brak Produktu");
			
			products.add(theProduct);
		}
		
		return products;
	}

}
