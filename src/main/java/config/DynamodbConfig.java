package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamodbConfig {
	
	@Bean
	public DynamoDBMapper dynamoDBMapper() {
		return new  DynamoDBMapper(buildAmazonDynamoDB());
	}
	
	private AmazonDynamoDB buildAmazonDynamoDB() {
		return AmazonDynamoDBClientBuilder
				.standard()
				.withEndpointConfiguration(
						new AwsClientBuilder.EndpointConfiguration(
							
							
						"dynamodb.ap-south-1.amazonaws.com",
						"ap-south-1"
				)

			)
			.withCredentials(
					new AWSStaticCredentialsProvider(
							new BasicAWSCredentials(
									"your-access-key", 
									"your-secret-key"
									)
							)
					)
			.build();
			}
 }		