.PHONY: build dev

dev:
	bb src/gaiwan/build.clj
	cp -r resources/* _site/

build:
	rm -rf _site
	bb src/gaiwan/build.clj
	cp -r resources/* _site/