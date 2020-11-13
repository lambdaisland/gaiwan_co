# Gaiwan GmbH

This repository consists the code for our website https://gaiwan.co

We are a provider of technological exper­tise grown out of the consulting and de­vel­op­ment work of Arne Brasseur.

## Tech stack

We love Clojure, and this site is built with it! 

We're using [Babashka](https://github.com/borkdude/babashka) and [Bootleg](https://github.com/retrogradeorbit/bootleg) to build a static site.

##  Architechture

All the source files are located in `src/gaiwan` directory. All static resources are availble in `resources` directory.

The entry point for the generation of the site is `build.clj`

The generated site is placed inside a folder `_site`. This is ingored in the current branch because we want to keep source and generated history separate.

This is accomplished by tracking the changes in generated `_site` folder as a git worktree and deploy to it the `gh-pages` branch.

Github will then deploy whatever it finds in the `gh-pages` branch.

## Local development

First make sure you have latest versions `bb` (babshka) and `bootleg` installed.

Then clone the repository and run:

```bash
make build # this will generate a `_site` folder.
cd _site
# now run a simple http server
python3 -m http.server --bin 0.0.0.0 8001
```

The `resources` directory is copied to the final site as is.

## Deployment

For first time deployment there is an extra step involved where you need to run the following commands:

```bash
rm -rf _site
git worktree add -B gh-pages public origin/gh-pages
```

Once you're satisfied with the changes, deploy the site live by running:

```
make deploy
```

## TODO

Currently the setup is extremely simple and minimal. Everytime you make a change you need to rerun the build command. This is tiresome and we need to find a way to autobuild on file changes.

An interesting solution would be to move the entire build step into babashka's build file and use the babashka-file-watcher pod.

Another problem is that the css/js assets are not being hashed. This can lead to caching issues. We can use babashka and `sha1sum` utility present on linux systems to build on this.

## Contribute