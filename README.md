### CS305
SNHU CS305 Submission

##Briefly summarize your client, Artemis Financial, and its software requirements. Who was the client? What issue did the company want you to address?
Artemis Financial is a financial institution looking to increase security in their already existing system, making it compliant with security requirements of more clients.

##What did you do well when you found your client’s software security vulnerabilities? Why is it important to code securely? What value does software security add to a company’s overall well-being?
I found myself most engrossed in the coding part of the process. It might be because it was the part I'm most familiar with. I think this was the first time I've actually experienced "dependency hell", when trying to update and remove potential vulnerabilities via third party libraries. I don't believe it says as much when things are picked out of comfort of the known compared to the "unknown", but I hope to gain more skills and know I like or dislike something out of understanding than ignorance.

##Which part of the vulnerability assessment was challenging or helpful to you?
Once I understood how to use the dependency check, it gave me an idea of what might need to be updated and how to prioritize what to fix. But it doesn't tell you things like, what the newest version of the dependency is, or if it would even work with your current framework version or JDK version. There's still a lot of research in order to know if it'll work, and not a "just upgrade everything" affair.

##How did you increase layers of security? In the future, what would you use to assess vulnerabilities and decide which mitigation techniques to use?
I updated a lot of the dependencies, even if I had to do so manually. I added SHA-256 and a form of AES. I have input checking by regex.  I tried penetration testing a little bit.

##How did you make certain the code and software application were functional and secure? After refactoring the code, how did you check to see whether you introduced new vulnerabilities?
I had to run a lot of debugs, constantly running the program, making sure that it still ran as intended. The point of refactoring is to add more functionality without changing overall how it operates on the outside. I would test, check, change, then test again. 

##What resources, tools, or coding practices did you use that might be helpful in future assignments or tasks?
I Googled a lot, which led me to locations like Github, and Stackoverflow. 

##Employers sometimes ask for examples of work that you have successfully completed to show your skills, knowledge, and experience. What might you show future employers from this assignment?
My use of a hash function to send encrypted communications.


