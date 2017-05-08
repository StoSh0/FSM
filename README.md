# FSM# FSM
<h2>
    Tests Roboelectric and Mockito
<h2>
<p>
    I tried to run the test library Roboelectric. And this result=( Error:
</p>
<img src="http://savepic.ru/13831393.png" border="10" alt="Изображение - savepic.ru — сервис хранения изображений" />
<p>
  <img src="http://savepic.ru/13854956.png" border="10" alt="Изображение - savepic.ru — сервис хранения изображений" />
</p>

<p>
  I read various tutorial, but it does not solve the problem.
    Maybe it's because I have not worked with such tests
</p>

<h1>
  I fixed Exception
</h1>
<img src="http://savepic.ru/13889499.png" border="0" alt="Изображение - savepic.ru — сервис хранения изображений" />
<p> 
  The problem was in the incorrect configuration setting,  but now I corrected all: <img src="http://savepic.ru/13882331.png"              border="0" alt="Изображение - savepic.ru — сервис хранения изображений" />
</p>

<h1> UML class : </h1>
<p> That is my code: 

<h6>@startuml
<p>
AlarmDisarmed_AllUnlocked -> AlarmDisarmed_AllLocked :Lock
</p>
<p>
AlarmDisarmed_DriverUnlocked -> AlarmDisarmed_AllLocked : Lock
</p>
<p>
AlarmDisarmed_AllUnlocked -> AlarmArmed_AllLocked : LockX2
</p>
<p>
AlarmDisarmed_DriverUnlocked -> AlarmArmed_AllLocked : LockX2
</p>
<p>
AlarmDisarmed_AllLocked -> AlarmArmed_AllLocked : LockX2
</p>
<p>
AlarmDisarmed_AllLocked -> AlarmDisarmed_DriverUnlocked : Unlock
</p>
<p>
AlarmArmed_AllLocked -> AlarmDisarmed_DriverUnlocked : Unlock
</p>
<p>
AlarmDisarmed_AllLocked -> AlarmDisarmed_AllUnlocked : UnlockX2
</p>
<p>
AlarmArmed_AllLocked -> AlarmDisarmed_AllUnlocked : UnlockX2
</p>
@enduml
<h6>

<h3>Result<h3>

<img src="http://savepic.ru/13848801.png" border="0" alt="Изображение - savepic.ru — сервис хранения изображений" />
