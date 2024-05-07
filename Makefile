.PHONY: build stop start

build: stop
	docker-compose build

stop:
	docker-compose -f docker-compose.yml down

start: stop
	docker-compose -f docker-compose.yml up --remove-orphans -d

remove-image:
	docker-compose down --rmi all

run:
	@echo `mvn spring-boot:run -X`

clean:
	@echo `mvn dependency:purge-local-repository`

create-db:
	@echo "Prepare container to use DB..."
	docker-compose -f docker-compose.yml up -d postgresdb
	@echo "Wait until mysql docker image up and running?"
	while [ $$(docker inspect --format "{{json .State.Status }}" $$(docker-compose -f docker-compose.yml ps -q postgresdb)) != "\"running\"" ]; do printf "."; sleep 1; done

	@echo "Drop DB if exists"
	docker exec -it minden-rest-api_postgresdb_1 sh -c 'psql -U minden-rest -W -c "CREATE DATABASE mindenDbrest;"'

