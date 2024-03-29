// Generated on 2016-03-08 using generator-jhipster 2.27.2
/* jshint camelcase: false */
'use strict';

var gulp = require('gulp'),
    prefix = require('gulp-autoprefixer'),
    cssnano = require('gulp-cssnano'),
    usemin = require('gulp-usemin'),
    uglify = require('gulp-uglify'),
    htmlmin = require('gulp-htmlmin'),
    imagemin = require('gulp-imagemin'),
    ngAnnotate = require('gulp-ng-annotate'),
    ngConstant = require('gulp-ng-constant-fork'),
    jshint = require('gulp-jshint'),
    rev = require('gulp-rev'),
    proxy = require('proxy-middleware'),
    es = require('event-stream'),
    flatten = require('gulp-flatten'),
    del = require('del'),
    url = require('url'),
    wiredep = require('wiredep').stream,
    runSequence = require('run-sequence'),
    browserSync = require('browser-sync'),
    sourcemaps = require('gulp-sourcemaps'),
    KarmaServer = require('karma').Server,
    plumber = require('gulp-plumber'),
    changed = require('gulp-changed'),
    cache = require('gulp-cached'),
    handleErrors = require('./gulp/handleErrors'),
    util = require('./gulp/utils');

var config = {
    app: 'src/main/webapp/',
    dist: 'src/main/webapp/dist/',
    test: 'src/test/javascript/',
    port: 9000,
    apiPort: 8080,
    liveReloadPort: 35729
};

gulp.task('clean', function () {
    return del([config.dist]);
});

gulp.task('test', ['wiredep:test', 'ngconstant:dev'], function(done) {
    new KarmaServer({
        configFile: __dirname + '/' + config.test + 'karma.conf.js',
        singleRun: true
    }, done).start();
});


gulp.task('copy', function() {
    return es.merge(  // copy i18n folders only if translation is enabled
        gulp.src(config.app + 'i18n/**')
        .pipe(plumber({errorHandler: handleErrors}))
        .pipe(changed(config.dist + 'i18n/'))
        .pipe(gulp.dest(config.dist + 'i18n/')), 
        gulp.src(config.app + 'bower_components/bootstrap/fonts/*.*')
        .pipe(plumber({errorHandler: handleErrors}))
        .pipe(changed(config.dist + 'assets/fonts/'))
        .pipe(gulp.dest(config.dist + 'assets/fonts/')),
        gulp.src(config.app + 'assets/**/*.{woff,svg,ttf,eot}')
        .pipe(plumber({errorHandler: handleErrors}))
        .pipe(changed(config.dist + 'assets/fonts/'))
        .pipe(flatten())
        .pipe(gulp.dest(config.dist + 'assets/fonts/')));
});

gulp.task('images', function() {
    return gulp.src(config.app + 'assets/images/**')
        .pipe(plumber({errorHandler: handleErrors}))
        .pipe(changed(config.dist + 'assets/images'))
        .pipe(imagemin({optimizationLevel: 5}))
        .pipe(gulp.dest(config.dist + 'assets/images'))
        .pipe(browserSync.reload({stream: true}));
});

gulp.task('styles', [], function() {
    return gulp.src(config.app + 'assest/styles')
        .pipe(browserSync.reload({stream: true}));
});

gulp.task('install', function(done) {
    runSequence('wiredep', 'ngconstant:dev', done);
});

gulp.task('serve', function() {
    runSequence('install', function () {
        var baseUri = 'http://localhost:' + config.apiPort;
        // Routes to proxy to the backend. Routes ending with a / will setup
        // a redirect so that if accessed without a trailing slash, will
        // redirect. This is required for some endpoints for proxy-middleware
        // to correctly handle them.
        var proxyRoutes = [
            '/api',
            '/health',
            '/configprops',
            '/env',
            '/v2/api-docs',
            '/swagger-ui',
            '/configuration/security',
            '/configuration/ui',
            '/swagger-resources',
            '/metrics',
            '/websocket/tracker',
            '/dump'
        ];

        var requireTrailingSlash = proxyRoutes.filter(function (r) {
            return util.endsWith(r, '/');
        }).map(function (r) {
            // Strip trailing slash so we can use the route to match requests
            // with non trailing slash
            return r.substr(0, r.length - 1);
        });

        var proxies = [
            // Ensure trailing slash in routes that require it
            function (req, res, next) {
                requireTrailingSlash.forEach(function(route){
                    if (url.parse(req.url).path === route) {
                        res.statusCode = 301;
                        res.setHeader('Location', route + '/');
                        res.end();
                    }
                });

                next();
            }
        ]
        .concat(
            // Build a list of proxies for routes: [route1_proxy, route2_proxy, ...]
            proxyRoutes.map(function (r) {
                var options = url.parse(baseUri + r);
                options.route = r;
                options.preserveHost = true;
                return proxy(options);
            }));

        browserSync({
            open: true,
            port: config.port,
            server: {
                baseDir: config.app,
                middleware: proxies
            }
        });

        gulp.start('watch');
    });
});

gulp.task('watch', function() {
    gulp.watch('bower.json', ['wiredep']);
    gulp.watch(['gulpfile.js', 'pom.xml'], ['ngconstant:dev']);
    gulp.watch(config.app + 'assets/styles/**/*.css', ['styles']);
    gulp.watch(config.app + 'assets/images/**', ['images']);
    gulp.watch(config.app + 'scripts/**/*.js', ['jshint']);
    gulp.watch([config.app + '*.html', config.app + 'scripts/**', config.app + 'i18n/**']).on('change', browserSync.reload);
});

gulp.task('wiredep', ['wiredep:test', 'wiredep:app']);

gulp.task('wiredep:app', function () {
    var stream = gulp.src(config.app + 'index.html')
        .pipe(plumber({errorHandler: handleErrors}))
        .pipe(wiredep({
            exclude: [/angular-i18n/]
        }))
        .pipe(gulp.dest(config.app));

    return stream;
});

gulp.task('wiredep:test', function () {
    return gulp.src(config.test + 'karma.conf.js')
        .pipe(plumber({errorHandler: handleErrors}))
        .pipe(wiredep({
            exclude: [/angular-i18n/, /angular-scenario/],
            ignorePath: /\.\.\/\.\.\//, // remove ../../ from paths of injected javascripts
            devDependencies: true,
            fileTypes: {
                js: {
                    block: /(([\s\t]*)\/\/\s*bower:*(\S*))(\n|\r|.)*?(\/\/\s*endbower)/gi,
                    detect: {
                        js: /'(.*\.js)'/gi
                    },
                    replace: {
                        js: '\'{{filePath}}\','
                    }
                }
            }
        }))
        .pipe(gulp.dest(config.test));
});

gulp.task('build', function (cb) {
    runSequence('clean', 'copy', 'wiredep:app', 'ngconstant:prod', 'usemin', cb);
});

gulp.task('usemin', ['images', 'styles'], function() {
    return gulp.src([config.app + '**/*.html', '!' + config.app + '@(dist|bower_components)/**/*.html'])
        .pipe(plumber({errorHandler: handleErrors}))
        .pipe(usemin({
            css: [
                prefix,
                'concat',
                cssnano,
                rev
            ],
            html: [
                htmlmin.bind(htmlmin, {collapseWhitespace: true})
            ],
            js: [
                sourcemaps.init,
                ngAnnotate,
                'concat',
                uglify.bind(uglify, { mangle: false }),
                rev,
                sourcemaps.write.bind(sourcemaps.write, '.')
            ]
        }))
        .pipe(gulp.dest(config.dist));
});

gulp.task('ngconstant:dev', function() {
    return ngConstant({
        dest: 'app.constants.js',
        name: 'jhipsterApp',
        deps:   false,
        noFile: true,
        interpolate: /\{%=(.+?)%\}/g,
        wrap: '/* jshint quotmark: false */\n"use strict";\n// DO NOT EDIT THIS FILE, EDIT THE GULP TASK NGCONSTANT SETTINGS INSTEAD WHICH GENERATES THIS FILE\n{%= __ngModule %}',
        constants: {
            ENV: 'dev',
            VERSION: util.parseVersion()
        }
    })
    .pipe(gulp.dest(config.app + 'scripts/app/'));
});

gulp.task('ngconstant:prod', function() {
    return ngConstant({
        dest: 'app.constants.js',
        name: 'jhipsterApp',
        deps:   false,
        noFile: true,
        interpolate: /\{%=(.+?)%\}/g,
        wrap: '/* jshint quotmark: false */\n"use strict";\n// DO NOT EDIT THIS FILE, EDIT THE GULP TASK NGCONSTANT SETTINGS INSTEAD WHICH GENERATES THIS FILE\n{%= __ngModule %}',
        constants: {
            ENV: 'prod',
            VERSION: util.parseVersion()
        }
    })
    .pipe(gulp.dest(config.app + 'scripts/app/'));
});

gulp.task('jshint', function() {
    //Custom reporter (in task to have new instance each time)
    var jsHintErrorReporter = require('./gulp/jsHintErrorReporter');

    return gulp.src(['gulpfile.js', config.app + 'scripts/**/*.js'])
        .pipe(plumber({errorHandler: handleErrors}))
        .pipe(cache('jshint'))
        .pipe(jshint())
        .pipe(jshint.reporter('jshint-stylish'))
        .pipe(jsHintErrorReporter());
});


gulp.task('default', ['serve']);
