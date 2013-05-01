# hlisp

A Leiningen template for creating HLisp projects.

## Documentation

HLisp documentation:

http://github.com/tailrecursion/lein-hlisp

## Usage

1. Create your project.

```bash
$ lein new hlisp foo
```

2. Go to your new project root directory.

```bash
$ cd foo
```

3. Compile your project.

```bash
$ lein hlisp
```

4. Start a local HTTP server.

```bash
$ cd resources/public && python -m SimpleHTTPServer
```

5. View the application at http://localhost:8000.

## License

Copyright © 2013 FIXME

Distributed under the Eclipse Public License, the same as Clojure.

