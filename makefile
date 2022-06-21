bin: evil
	mkdir -p bin
	echo '#!/bin/bash' > bin/evil
	echo 'java -jar ${pwd}/target/evil-synth-0.0.0-standalone.jar "$$@"' >> bin/evil 
	echo 'exit' >> bin/evil 
	chmod +x bin/evil

evil: project.clj src/evil.clj 
	lein uberjar

tests: examples.zip
	unzip examples.zip

clean:
	rm -rf examples
	rm -rf bin 
	rm -rf target 
	rm -f *.v
	rm -f *.blif
	find . -name "*~" | xargs rm
