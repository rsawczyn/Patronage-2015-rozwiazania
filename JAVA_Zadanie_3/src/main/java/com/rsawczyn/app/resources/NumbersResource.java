package com.rsawczyn.app.resources;

import com.rsawczyn.app.core.Numbers;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/api/numbers")
@Produces(MediaType.APPLICATION_JSON)
public class NumbersResource {
	
	private Numbers numbers;
	
    public NumbersResource(Numbers numbers) {
		this.numbers = numbers;
    }

	// wyswietlanie listy liczb w kolejnosci dodawania
    @GET
	@Path("/listInAddingOrder")
    public String displayListInAddingOrder() {
		return numbers.getList().toString();
    }
	
	// dodawnie kolejnej liczby - liczba jest przekazana jako parametr w ścieżce.
	@POST
	@Path("/{number}")
	public String addNumber(@PathParam("number") String number) {
        numbers.addNumber(new BigDecimal(number));
		return "Added \"" + number + "\" to list!";
    }
	
	// wyswietlanie listy liczb posortowanych rosnąco
	@GET 
	@Path("/listInAscendingOrder")
	public String displayListInAscendingOrder() {
		return numbers.doSort().toString();
    }
	
	// wyswietlanie sumy
	@GET 
	@Path("/sum")
	public String displaySum() {
		return "Suma: " + numbers.sum();
    }
	
	// wyswietlanie średniej
	@GET 
	@Path("/average")
	public String displayAverage() {
		return "Srednia: " + numbers.average();
    }
}