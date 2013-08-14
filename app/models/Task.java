
package models;

import java.util.*;

import play.db.ebean.Model;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
public class Task extends Model {

	@Id  
	public Long id;
	@Required
	public String subject;
	public Boolean isCompleted = false;

	public static Finder<Long,Task> find = new Finder(
			Long.class, Task.class
			);  

	public static List<Task> all() {
		return find.all();
	}

	public static Long create(Task task) {
		task.save();
		return task.id;
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

	public static Task findById(Long id){
		return find.ref(id);
	}

	public static void update(Task task){
		task.update();
	}
}
