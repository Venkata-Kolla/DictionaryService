package com.restPackage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import DictionaryRule.DictionaryRuleEnforcer;

@Path("/nameNum/")
public class NameNumber {

	@GET
	@Produces("application/json")
	public Response getWords() throws JSONException{
		JSONObject json = new JSONObject();
		json.put("1", "Venkat");
		String result = "@Produces(\"application/json\") Output: \n\n Names are: \n\n "+json;
		return Response.status(200).entity(result).build();
	}
	
	@Path("{word}")
	@GET
	@Produces("application/json")
	public Response checkWordValidity(@PathParam("word") String word) throws JSONException{
		DictionaryRuleEnforcer dictRule = new DictionaryRuleEnforcer();
		JSONObject json = new JSONObject();
		if(dictRule.inputTextEntryMethod(word)) {
			json.put(word, "is a valid word");
		}
		else {
			json.put(word, "is not a valid word");
		}
		String result = "@Produces(\"application/json\") Output: \n\n Names are: \n\n "+json;
		return Response.status(200).entity(result).build();
	}
	/*
	@Path("{n}")
	@GET
	@Produces("application/json")
	public Response getWordsForNum(@PathParam("n") int n) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("Venkat", n);
		String result = "@Produces(\"application/json\") Output: \n\n Names are: \n\n "+json;
		return Response.status(200).entity(result).build();
	}*/
}
