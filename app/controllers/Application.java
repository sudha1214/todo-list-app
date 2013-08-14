package controllers;


import java.util.List;
import models.*;
import play.mvc.*;
import play.libs.Json;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;
import views.html.*;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render());
	}

	//get all tasks
	public static Result getAllTasks() {
		List<Task> tasks = Task.all();  
		return ok(Json.toJson(tasks));
	}

	//get 1 task
	public static Result getTask(Long id) {
		try{
			Task task = Task.findById(id);  
			return ok(Json.toJson(task));
		}
		catch(Exception e){
			ObjectNode result = Json.newObject();
			result.put("status", "error");
			return badRequest(result);
		}
	}    

	//update task
	@BodyParser.Of(BodyParser.Json.class)
	public static Result updateTask(Long id) {
		ObjectNode result = Json.newObject();
		try{
			JsonNode json = request().body().asJson();
			String subject = json.findPath("subject").getTextValue();
			Boolean isCompleted = Boolean.parseBoolean(json.findPath("isCompleted").getTextValue());

			Task task = new Task();
			task.subject = subject;
			task.id = id;
			task.isCompleted = isCompleted;
			Task.update(task);
			result.put("status", "OK");
			return ok(result);
		}
		catch (Exception e){
			result.put("status", "error");
			return badRequest(result);            
		}
	}


	//create task
	@BodyParser.Of(BodyParser.Json.class)
	public static Result createTask() {
		ObjectNode result = Json.newObject();
		try{
			JsonNode json = request().body().asJson();
			String subject = json.findPath("subject").getTextValue();
			Task task = new Task();
			task.subject = subject;

			Long id = Task.create(task);
			result.put("status", "OK");
			result.put("id",id);
			return ok(result);
		}
		catch(Exception e){
			result.put("status", "error");
			return badRequest(result);      
		}
	}

	//delete task
	public static Result deleteTask(Long id) {
		ObjectNode result = Json.newObject();
		try{

			Task task = Task.findById(id);
			task.delete();
			result.put("status", "OK");
			return ok(result);
		}
		catch(Exception e){
			result.put("status", "error");
			return badRequest(result);      
		}
	} 

}
