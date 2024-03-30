# Pact Demo

Provider is a **order** provider, it has a GET api

Comsumer comsumes **order**, it calls GET api from Provider

<img width="331" alt="image" src="https://github.com/Rico00121/pact-demo/assets/52640916/77e29003-bb3b-40a0-a592-ad6f039d9e50">

And **order**'s schema:
```
data class Order(var id: Int? = null)
```

## How to Use
- Sign up and Login pactflow account
- Click here and get pactflow paltform's access token
  
  <img width="567" alt="image" src="https://github.com/Rico00121/pact-demo/assets/52640916/d8488ece-0910-4d07-9315-a71ae656dabc">
  <img width="1500" alt="image" src="https://github.com/Rico00121/pact-demo/assets/52640916/381c2c49-3324-46ff-97f9-ed582370a81b">
- Paste access token and url to here for publishing pact.
  <img width="1043" alt="image" src="https://github.com/Rico00121/pact-demo/assets/52640916/9d24f323-6e0f-4405-a722-9dd54418d412">
- Paste access token and url to here for pulling and verify pact.
  <img width="1257" alt="image" src="https://github.com/Rico00121/pact-demo/assets/52640916/6bea8da1-2122-49ae-a444-e01476933c67">
