JAVA_SCRIPT_MODULES := jeorg-javascript-alg2-floyd-tortoise-hare \
					   jeorg-javascript-alg3-brent-tortoise-hare \
					   jeorg-javascript-alg4-activity-selector \
					   jeorg-javascript-alg-hanoi-towers

coverage:
	cd jeorg-javascript-algorithms/jeorg-javascript-alg-hanoi-towers && npm run coverage
	cd jeorg-javascript-algorithms/jeorg-javascript-alg2-floyd-tortoise-hare && npm run coverage
	cd jeorg-javascript-algorithms/jeorg-javascript-alg3-brent-tortoise-hare && npm run coverage
	cd jeorg-javascript-algorithms/jeorg-javascript-alg4-activity-selector && npm run coverage
	coverage run --source=jeorg-python-algorithms -m pytest && coverage json
coverage-all: coverage
	mvn clean install jacoco:prepare-agent install package jacoco:report
install:
	cd jeorg-javascript-algorithms/jeorg-javascript-alg-hanoi-towers && yarn && yarn add jest --dev
	cd jeorg-javascript-algorithms/jeorg-javascript-alg2-floyd-tortoise-hare && yarn && yarn add jest --dev
	cd jeorg-javascript-algorithms/jeorg-javascript-alg3-brent-tortoise-hare && yarn && yarn add jest --dev
	cd jeorg-javascript-algorithms/jeorg-javascript-alg4-activity-selector && yarn && yarn add jest --dev
upgrade-local:
	sudo apt update
	sudo apt-get -y install python3-pip
	sudo apt-get -y install npm
	sudo npm install --global yarn
	sudo npm install -g n
	sudo npm install -g npm@10.2.3
	sudo n 18
	curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.5/install.sh | bash
	nvm install --lts
remove-lock-files:
	find . -name "package-lock.json" | xargs -I {} rm {}; \
	find . -name "yarn.lock" | xargs -I {} rm {};
update: remove-lock-files
	npm install -g npm-check-updates
	git pull
	npm install caniuse-lite
	npm install -g npm-check-updates
	npm install -g jest
	@for location in $(JAVA_SCRIPT_MODULES); do \
  		export CURRENT=$(shell pwd); \
  		echo "Building jeorg-javascript-algorithms/$$location..."; \
		pwd; \
		cd jeorg-javascript-algorithms/$$location; \
		pwd; \
 		yarn; \
 		ncu -u; \
 		yarn ; \
 		npm test; \
		cd $$CURRENT; \
	done
