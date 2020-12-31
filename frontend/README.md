# Angular 10 JWT Authentication example

ng build --prod

Сборка образа - "docker build -t angular-10-jwt-auth ." 

Запуск образа - "docker run -p 80:80 angular-10-jwt-auth"

docker login

docker tag c89b6dc0f7e5 nemchinovrp/angular-10-jwt-auth:0.0.1

docker push nemchinovrp/angular-10-jwt-auth
