package guru.springframework.springrestclientexamples.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import guru.springframework.api.domain.User;
import guru.springframework.api.domain.UserData;

@Service
public class ApiServiceImpl implements ApiService{

	private RestTemplate restTemplate;
	
	public ApiServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Override
	public List<User> getUsers(Integer limit) {
		
		//UserData userData = restTemplate.getForObject("?limit="+limit,UserData.class);

		String apiUri = "http://apifaketory.com/api/user";
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(apiUri).queryParam("limit", limit);
		UserData userData = restTemplate.getForObject(uriBuilder.toUriString(), UserData.class);		
		return userData.getData();
	}

}
