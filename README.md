# hlisp

A Leiningen template for creating HLisp projects.

## Documentation

HLisp documentation:

http://github.com/tailrecursion/lein-hlisp

## Usage

Create your project.

```bash
$ lein new hlisp foo
```

Go to your new project root directory.

```bash
$ cd foo
```

Compile your project.

```bash
$ lein hlisp
```

Start a local HTTP server.

```bash
$ cd resources/public && python -m SimpleHTTPServer
```

View the application at http://localhost:8000.

### Note

You can start the HLisp compiler in "watcher" mode and it will recompile files
automatically whenever a source file is changed.

```bash
$ lein hlisp auto
```

## License

Copyright © 2013 Micha Niskin

Distributed under the Eclipse Public License, the same as Clojure.

