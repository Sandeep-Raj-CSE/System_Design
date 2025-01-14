
observer

- it is behavioral design pattern that lets you
define the subscription mechanism to notify multiple
people at once


customer       product

iphone         comingsoon...

iphone        comingsoon...



- so customer visit store and know product is not
available then visiting is pointless

- and other hand if store send email to everyone and say
  iphone is available is also a point less


state change  -> notify -> observer

s1 ->notify ->observer


observable interface -> 
<List>obserIntefacer
- add(observerInterface obj)
- remove(objserInterface obj)
- notify()
- setdata()

-> (0,*)
observer interface
- update()

- observer concerte class
- add(observerInterface obj){
- objlist.add(obj)
- }

- remove(observeInter obj){
- objlist.remove(obj)
- }

notify(){

for(ObserverInterface obj:objlist){
obj.update()