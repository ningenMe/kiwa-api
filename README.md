```
docker-compose -f ./tool/docker-compose.yaml up
```

# local

```shell
# user-post
curl -XPOST -d '{"userId":"user0","password":"hoge"}' -H 'Content-Type: application/json' localhost:8080/users -i
# login
curl -XPOST -d '{"userId":"user0","password":"hoge"}' -H 'Content-Type: application/json' localhost:8080/login -i | grep cookie | awk '{print $2}'
# user-me-get
curl -b `curl -XPOST -d '{"userId":"user0","password":"hoge"}' -H 'Content-Type: application/json' localhost:8080/login -i | grep cookie | awk '{print $2}'` localhost:8080/users/me -i
```

# prod

```shell
# user-post
curl -XPOST -d '{"userId":"user0","password":"hoge"}' -H 'Content-Type: application/json' https://kiwa-api.ningenme.net/users -i
# login
curl -XPOST -d '{"userId":"user0","password":"hoge"}' -H 'Content-Type: application/json' https://kiwa-api.ningenme.net/login -i | grep cookie | awk '{print $2}'
# user-me-get
curl -b `curl -XPOST -d '{"userId":"user0","password":"hoge"}' -H 'Content-Type: application/json' https://kiwa-api.ningenme.net/login -i | grep cookie | awk '{print $2}'` https://kiwa-api.ningenme.net/users/me -i
```

# db

```shell
insert into authority (authority_id) values ('COMPRO_CATEGORY');
insert into relation_user_authority (user_id, authority_id) values ('user0','COMPRO_CATEGORY');
```