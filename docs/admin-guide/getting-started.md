## Assumptions
* You have successfully deployed the CATCH-A web application to a cloud service of your choosing (AWS EC2, AWS EBS, DigitalOcean, RimuHosting, etc).
* A developer who wants to access the CATCH-A API has requested an API key.

## Create an API Client 
Currently, there's no way for developers to request or manage their client API keys, so the owner of the API instance needs to manually create API keys for external developers. 

To create a new client API key you need to log into CATCH-A as an administrator. 

#### Navigate to admin console
* Example URL if running the API locally: [http://localhost:8080/catch](http://localhost:8080/catch)

#### Log in as an admin
* Username: admin
* Password: password

![Screenshot](/img/login.png)

### Administrative dashboard
* Navigate your browser to the [CATCH-A Admin Dashboard](http://localhost:8080/catch/dashboard/index) by clicking the Administration Dashboard link at the top of the page.

![Screenshot](/img/home.png)

### List all existing systems
* Click the List Systems link in the leftnav to view existing systems

![Screenshot](/img/list-systems.png)


### Create a new system
* Click the Create System link in the leftnav
* Enter a descriptive name (e.g."Justin's Demo Client API")
* Enter a short code ("JUSTIN-DEMO").
* Enter the client URL (and the client developer's email address) in the description field so that we can contact the client developer in case of an issue.
* Click the Save System button.

![Screenshot](/img/create-system.png)

### Distribute API key
* Distribute the API and Secret keys from the Show System page to the developer.

![Screenshot](/img/show-system.png)

