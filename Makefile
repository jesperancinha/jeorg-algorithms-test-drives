include Makefile.mk

JAVA_SCRIPT_MODULES := jeorg-javascript-alg2-floyd-tortoise-hare \
					   jeorg-javascript-alg3-brent-tortoise-hare \
					   jeorg-javascript-alg4-activity-selector \
					   jeorg-javascript-alg-hanoi-towers
b: update
coverage:
	source myenv/bin/activate;\
	cd jeorg-javascript-algorithms/jeorg-javascript-alg-hanoi-towers && npm run coverage
	source myenv/bin/activate;\
	cd jeorg-javascript-algorithms/jeorg-javascript-alg2-floyd-tortoise-hare && npm run coverage
	source myenv/bin/activate;\
	cd jeorg-javascript-algorithms/jeorg-javascript-alg3-brent-tortoise-hare && npm run coverage
	source myenv/bin/activate;\
	cd jeorg-javascript-algorithms/jeorg-javascript-alg4-activity-selector && npm run coverage
	source myenv/bin/activate;\
	coverage run --source=jeorg-python-algorithms -m pytest && coverage json
coverage-all: coverage
	mvn clean install jacoco:prepare-agent install package jacoco:report
install:
	cd jeorg-javascript-algorithms/jeorg-javascript-alg-hanoi-towers && yarn && yarn add jest --dev
	cd jeorg-javascript-algorithms/jeorg-javascript-alg2-floyd-tortoise-hare && yarn && yarn add jest --dev
	cd jeorg-javascript-algorithms/jeorg-javascript-alg3-brent-tortoise-hare && yarn && yarn add jest --dev
	cd jeorg-javascript-algorithms/jeorg-javascript-alg4-activity-selector && yarn && yarn add jest --dev
create-pip-env:
	python3 -m venv myenv &&
	source myenv/bin/activate &&
	pip3 install coverage &&
	pip3 install pytest
upgrade-local:
	sudo apt update
	sudo apt-get -y install python3-pip python3-venv
	sudo apt-get -y install npm
	sudo npm install --global yarn
	curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.5/install.sh | bash
	nvm install --lts
remove-lock-files:
	find . -name "package-lock.json" | xargs -I {} rm {}; \
	find . -name "yarn.lock" | xargs -I {} rm {};
update: remove-lock-files
	npm install -g npm-check-updates
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
deps-npm-update: update
deps-plugins-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/pluginUpdatesOne.sh | bash
deps-java-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/javaUpdatesOne.sh | bash
deps-node-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/nodeUpdatesOne.sh | bash
deps-quick-update: deps-plugins-update deps-java-update deps-node-update
accept-prs:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/acceptPR.sh | bash
