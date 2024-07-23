# Product Management Backend

## Description

Ce projet est un backend développé en Java avec le framework Spring Boot. Il permet la gestion des produits avec les opérations CRUD (Create, Read, Update, Delete). Les données des produits sont stockées dans une base de données PostgreSQL. Le backend expose des API REST pour gérer les produits.

## Prérequis

Avant de commencer, assurez-vous d'avoir les outils suivants installés sur votre machine :

- JDK 11 ou supérieur
- Apache Maven
- PostgreSQL
- Un IDE (IntelliJ IDEA, Eclipse, etc.)

## Installation

### 1. Cloner le projet

Clonez ce dépôt sur votre machine locale 

```bash
git clone https://github.com/yourusername/product_management.git
cd product-management
```

#### Configuration de la base de données PostgreSQL


### 2. Configuration de la base de données PostgreSQL

Créez une base de données PostgreSQL et un utilisateur :

```sql
CREATE DATABASE product;
CREATE USER postgres WITH ENCRYPTED PASSWORD 'postgres';
GRANT ALL PRIVILEGES ON DATABASE product TO postgres;
```

Remarque : Changez le nom d'utilisateur et le mot de passe en fonction de votre configuration PostgreSQL.


#### Configuration de l'application

### 3. Configuration de l'application

Modifiez le fichier `src/main/resources/application.properties` pour configurer la connexion à la base de données :

```properties
spring.application.name=product
server.port=3090
logging.level.org.springframework.web=DEBUG
spring.datasource.url=jdbc:postgresql://localhost:5432/product
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=create-drop

springdoc.api-docs.path=/swagger/api-docs
springdoc.swagger-ui.path=/swagger/swagger-ui.html
```


#### Construction et exécution de l'application


### 4. Construction et exécution de l'application

Utilisez Maven pour compiler et exécuter l'application :

```bash
mvn clean install
mvn spring-boot:run
```

L'application sera accessible sur http://localhost:3090.



### API Endpoints


## API Endpoints

L'application expose les API REST suivantes pour gérer les produits :

| Resource           | POST                  | GET                            | PATCH                                    | DELETE           |
| ------------------ | --------------------- | ------------------------------ | ---------------------------------------- | ---------------- |
| **/products**      | Create a new product  | Retrieve all products          | X                                        | X                |
| **/products/{id}** | X                     | Retrieve details for product   | Update details of product if it exists   | Remove product   |



### Modèle de données

Un produit a les caractéristiques suivantes :

```typescript
class Product {
  id: number;
  code: string;
  name: string;
  description: string;
  price: number;
  quantity: number;
  inventoryStatus: string;
  category: string;
  image?: string;
  rating?: number;
}
```


### Exemples de requêtes

- **Créer un produit**

  ```http
  POST /products
  Content-Type: application/json

  {
    "code": "P001",
    "name": "Product 1",
    "description": "Product 1 description",
    "price": 100.00,
    "quantity": 10,
    "inventoryStatus": "In Stock",
    "category": "Electronics",
    "image": "product1.jpg",
    "rating": 4.5
  }
  ```


Obtenir tous les produits
```
GET /products
```
Obtenir un produit par ID
```
GET /products/{id}
```

Mettre à jour un produit
```
PATCH /products/{id}
Content-Type: application/json

{
  "code": "P002",
  "name": "Updated Product",
  "description": "Updated description",
  "price": 150.00,
  "quantity": 5,
  "inventoryStatus": "Out of Stock",
  "category": "Home Appliances",
  "image": "updated_image.jpg",
  "rating": 4.8
}
```

Supprimer un produit
```
DELETE /products/{id}
```

### Documentation Swagger


## Documentation Swagger

Swagger est configuré pour documenter et tester les API. Accédez à Swagger UI via l'URL suivante :
```
http://localhost:3090/swagger/swagger-ui.html
```

Tests

## Tests

Vous pouvez utiliser Postman ou tout autre outil similaire pour tester les API. Une collection Postman est disponible en ligne via ce [lien](https://documenter.getpostman.com/view/37127779/2sA3kVm2CK#c7b70e85-0f03-40a1-b9ed-9456c7c332f0).
