package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;

import entity.Person;

@Repository
public class personrepository {
	
	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	
	public Person save(Person person) {
	   dynamoDBMapper.save(person);
	   return person;
}
	public Person getpersonById(String AadharId) {
		return dynamoDBMapper.load(Person.class,AadharId);
	}
	
	public String delete(String AadharId) {
		Person per = dynamoDBMapper.load(Person.class,AadharId);
		dynamoDBMapper.delete(per);
		return "Person deleted";
	}
	
	public String update(String AadharId, Person person) {
		dynamoDBMapper.save(person,
				new DynamoDBSaveExpression()
		.withExpectedEntry("AadharId",
				new ExpectedAttributeValue(
						new AttributeValue().withN(AadharId)
						)));
		return AadharId;
	}
}