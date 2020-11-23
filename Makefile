.PHONY: build dev

build:
	bb src/gaiwan/build.clj
	cp -r resources/* _site/

watch: build
	while true; do \
		inotifywait -r -e modify src/gaiwan resources; \
		make build ; \
	done

deploy: build
	cd _site && git add --all && git commit -m "Publishing to gh-pages" && cd ..
	git push origin gh-pages
