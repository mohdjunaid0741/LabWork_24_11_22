package com.lab;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.lab.agent.Agent;
import com.lab.dao.AgentRepository;


@SpringBootApplication
public class AssignmentApplication {

	public static void main(String[] args) {

		ApplicationContext c = SpringApplication.run(AssignmentApplication.class, args);
		AgentRepository ar = c.getBean(AgentRepository.class);
		
		//Create
		
		Agent a = new Agent();
		a.setName("Wheat");
		a.setPrice(25);
		a.setQuantity("2kg");
		
		Agent a1 = ar.save(a);
		System.out.println(a1);
		
		//Update
		
        Optional<Agent> optional = ar.findById(1);
		
		Agent a2 = optional.get();
		a2.setName("Rice");
		a2.setPrice(15);
		a2.setQuantity("5kg");
		
		Agent result1 = ar.save(a2);
		
		System.out.println(result1);
		
		// adding another Agents
		
		Agent a3 = new Agent();
		a3.setName("Wheat");
		a3.setPrice(30);
		a3.setQuantity("5kg");
								
		Agent a4 = new Agent();
		a4.setName("Pulse");
		a4.setPrice(24.5);
		a4.setQuantity("10kg");
				
		List<Agent> agent = List.of(a3,a4);
				
		Iterable<Agent> result = ar.saveAll(agent);
		result.forEach(Agent-> {
		System.out.println(Agent);
		});
		
		// deleting the agent
		
		ar.deleteById(3);
		System.out.println("Deleted id");
	}

}
