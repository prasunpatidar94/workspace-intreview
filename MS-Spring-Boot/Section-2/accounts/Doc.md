# Swagger URI	
```http://localhost:8080/swagger-ui/index.html```

# AccountsRestController API Documentation

**Base URL**: `/api`  
**Produces**: `application/json`  
**Tag**: `CURD Rest Services for Account in SunBank`  
**Description**: This account REST microservice is responsible for UPDATE, DELETE, GET, POST services for ACCOUNTS.

---

## 📍 `GET /api/acct` — Account Service Health Checker

**Summary**: Check health of the Account Microservice  
**Description**: REST endpoint to verify if the Account service is running properly.

### ✅ Response
- **200 OK**: `"Account's MicroService Good...!"`

---

## 📍 `POST /api/create` — Create Account

**Summary**: Create Account Rest API  
**Description**: REST API to create account and customer in SunBank.

### 🔁 Request Body
```json
{
  // CustomerDto fields (example)
}
