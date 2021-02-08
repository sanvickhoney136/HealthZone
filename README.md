Usecase:	Sustainability & wellness
Problem statement: Employee health monitoring system
	The problem statement is about a Remote Employee health monitoring system with safer data sharing from the employee and doctor without any intermediate. Then they need a platform to provide their sensitive information feel successful in sharing the data within their health systems and get fast response for their health condition status. So I developed a healthcare mobile application(for a single user) and web application (for multiple users-(employee and doctor)) with the help of existing Open API to solve the most interoperability and employee service issues. Healthcare data transactions and simultaneously secure and trustworthy due to the use of cryptographic principles. The employee can manage and share their health records are shared with secure and immutable audit trails to reduce systematic fraud. This case provides a remote employee health monitoring system, employees have their health records and shared their health records with the doctor. The doctor maintains the overall employees' health records and predicts if any employee's condition is normal or critical, the doctor provides the diagnosed report with a prescription to the employee. after that, the employee must follow the doctor's prescription and stay healthy to focus on their work.	

solution description:
*	Our project's main scope is securely tracking employee’s wellness. I have developed a mobile application for employee usage (single user). This app contains the Employee basic information like employee id, Name, automatically update the current location and Employee health information have an Open API deployed on the server(node.js) to gather the data from the database (Mongo DB) for the health impacting parameters, here I have used 14 parameters like Body temperature, blood pressure, respiration, glucose, Depression, heart rate, oxygen saturation, cholesterol ...etc.
*	These parameters are retained in my server(node.js) with random changes in parameter values for every 30 seconds. This node.js app is deployed in the Heroku cloud platform (live data). This live data uses Web3.js to make a data transaction between employee and doctor. Server-side requests and responses are fast because node.js is asynchronous and single-threaded so it handles easily. this task is more secured and convenient for employee and doctor management sides.
*	Data transfer processes are immutable for blockchain with the hashing techniques.
*	In the web application (for multiple users) part view all employee health records based on their health issues. At the end of the day which collects the user’s health information and provides the condition of their health summary for every user. If any critical warning to send the notification via email.
*	If employees asked about their health condition the doctor can communicate through the chatbot. The chatbot gives the current health status and helps to give the precautions depends on their health condition.
*	privacy of employee health information can be shared only got hash code. I achieved this scenario by using block code generating and sharing by appropriate users.
Solution Architecture:
	1. Overall Architecture: 
	
	
 2. Technical Architecture:
![tech](https://user-images.githubusercontent.com/75310734/107235861-21f92680-6a4b-11eb-87b1-84835665a421.PNG)

