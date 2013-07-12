simple-search-predicate
=======================

A simple grammar that helps prepare search predicates for many cases

This is a simple grammar which can be used in most of the enterprise apps where search is required. Instead of showing a cluttered search options, this language can be used to take search query.
This is similar to search in gmail.

Ex: from:foo@bar.com to:bar@foo.com few keywords

Above string will be parsed and keywords will be returned as set and attribute:value pairs are returned as Map from the AST visitor
