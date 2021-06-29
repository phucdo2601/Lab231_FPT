--load all role
select roleUserID, roleUserName
from roleUser
go
--select roleID BY role name
select roleUserID
from roleUser
where roleUserName = 'Management'
go

--dem role 
select count(roleUserID)
from roleUser
go

--loadAllUser
select userID, fullname, phone, email, imgUrl, roleID, [status], promoStatus, rankPromo, dateOfCreate, dateOfAddPromo
from [user]
go

--createAccount
insert into [user] (userID, [password], 
fullname, phone, [email], [imgUrl], [roleID], 
[status], [promoStatus], [dateOfCreate])
values (?,?,?,?,?,?,?,?,?,?)

--searchLikByFullname
select userID, fullname, phone, 
email, imgUrl, roleID, [status], 
promoStatus, rankPromo, 
dateOfCreate, dateOfAddPromo
from [user]
where fullname like ?
go

update [user]
set [password] = ?, fullname = ?, phone =?,
email = ?, imgUrl = ?
where userID = ?
go

--delete Account
update [user]
set status = 'InActive'
where userID = ?
go

--add PromoLIST
update [user]
set promoStatus = ?, rankPromo = ?
where userID = ?
go

--loadProStaActive
select promoStatusID
from promoStatus
where promoStatusID = 'Active'

select userID, fullname, phone, email, imgUrl, roleID, [status], promoStatus, rankPromo, dateOfCreate, dateOfAddPromo
from [user]
where promoStatus = ?
ORDER BY dateOfAddPromo

--load Admin Role
select roleUserID
from roleUser
where roleUserName = 'Management'
go

--load Status Active
select userStatusID
from userStatus
where userStatusID = 'Active'
go

--load PromoStatus NonActive
select promoStatusID
from promoStatus
where promoStatusID = 'NonActive'