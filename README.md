# Pact Demo

Provider is a **order** provider, it has a GET api

Comsumer comsumes **order**, it calls GET api from Provider

<img width="331" alt="image" src="https://github.com/Rico00121/pact-demo/assets/52640916/77e29003-bb3b-40a0-a592-ad6f039d9e50">

And **order**'s schema:
```
data class Order(var id: Int? = null)
```
