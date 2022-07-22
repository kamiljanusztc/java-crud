#!/usr/bin/env bash

export KODILLA_HOME=/Users/kamil/Desktop/JAVA\ CRUD/tasks

stop_runcrud()
{
   $KODILLA_HOME/runcrud.sh stop
}

start_runcrud()
{
   $KODILLA_HOME/runcrud.sh start
   end
}

openBrowser() {
  open -a "Google Chrome" http://localhost:8080/v1/tasks
}

fail() {
   echo "There were errors"
}

end() {
   echo "Work is finished"
}

if start_runcrud; then
   openBrowser
else
   fail
fi