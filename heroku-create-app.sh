#!/usr/bin/env sh

heroku apps:create geek-shopping-list
heroku addons:create heroku-postgresql:hobby-dev --app geek-shopping-list