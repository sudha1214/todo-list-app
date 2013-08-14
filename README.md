This is your new Play 2.1.1 application
=====================================
Problem:

Create a To-do List application to manage tasks. 

Functional requirement:

Basic features: 

1.     A task will contain 3 fields, id, subject and isCompleted 
2.     User can see all tasks 
3.     User can create task 
4.     User can remove task 
5.     UI styling is required to make the application show up nicely

Bonus features:
6.     [Bonus]: User can update task, user can update task subject and task status
7.     [Bonus]: User can see a count of all completed task, this count will update automatically upon task addition and deletion
8.     [Bonus]: User can choose to list the task by status like Completed, Open, All. By default task list should list all open tasks
 

2.     Restful services GET, POST, PUT and DELETE APIs are available. Endpoint URL is /tasks  	
a. 	   use [GET] /tasks to get all task
b.     use [GET] /tasks/[id] to get 1 task by Id
c.     use [PUT] /tasks/[id] with request body {"subject":"test update","isCompleted":"true"} to update task in server
d.     use [POST] /tasks with request body {"subject":"test subject"} to create task in server
e.     use [DELETE] /tasks/[id] to delete task in server


Instructions:

To start webserver: 

1. open terminal

2. enter "cd C:/todo-list-app"

3. enter "play.bat"

4. enter "run" 

5. open a browser and navigate to "http://localhost:9000" to land on the index.html page. You should see task manager printed on the page.



