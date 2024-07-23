# product_management

Description
Ce projet est un backend développé en Java avec le framework Spring Boot. Il permet la gestion des produits avec les opérations CRUD (Create, Read, Update, Delete). Les données des produits sont stockées dans une base de données PostgreSQL. Le backend expose des API REST pour gérer les produits.

Prérequis
Avant de commencer, assurez-vous d'avoir les outils suivants installés sur votre machine :

JDK 11 ou supérieur
Apache Maven
PostgreSQL
Un IDE (IntelliJ IDEA, Eclipse, etc.)
Installation
1. Cloner le projet
   Clonez ce dépôt sur votre machine locale :

bash
Copier le code
git clone https://github.com/yourusername/product-management.git
cd product-management
2. Configuration de la base de données PostgreSQL
   Créez une base de données PostgreSQL et un utilisateur :

sql
Copier le code
CREATE DATABASE productdb;
CREATE USER productuser WITH ENCRYPTED PASSWORD 'password';
GRANT ALL PRIVILEGES ON DATABASE productdb TO productuser;
3. Configuration de l'application
   Modifiez le fichier src/main/resources/application.properties pour configurer la connexion à la base de données :

properties
Copier le code
spring.datasource.url=jdbc:postgresql://localhost:5432/productdb
spring.datasource.username=productuser
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
4. Construction et exécution de l'application
   Utilisez Maven pour compiler et exécuter l'application :

bash
Copier le code
mvn clean install
mvn spring-boot:run
L'application sera accessible sur http://localhost:8080.

API Endpoints
L'application expose les API REST suivantes pour gérer les produits :

Resource	POST	GET	PATCH	DELETE
/products	Create a new product	Retrieve all products	X	X
/products/{id}	X	Retrieve details for product	Update details of product if it exists	Remove product
Modèle de données
Un produit a les caractéristiques suivantes :

typescript
Copier le code
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
Exemples de requêtes
Créer un produit

http
Copier le code
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
Obtenir tous les produits

http
Copier le code
GET /products
Obtenir un produit par ID

http
Copier le code
GET /products/{id}
Mettre à jour un produit

http
Copier le code
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
Supprimer un produit

http
Copier le code
DELETE /products/{id}
Documentation Swagger
Swagger est configuré pour documenter et tester les API. Accédez à Swagger UI via l'URL suivante :

bash
Copier le code
http://localhost:8080/swagger-ui/
Tests
Vous pouvez utiliser Postman ou tout autre outil similaire pour tester les API. Voici les étapes pour importer la collection Postman et tester les endpoints :

Ouvrez Postman.
Importez la collection JSON fournie dans ce projet (fichier postman_collection.json).
Exécutez les requêtes pour tester les différents endpoints.