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

