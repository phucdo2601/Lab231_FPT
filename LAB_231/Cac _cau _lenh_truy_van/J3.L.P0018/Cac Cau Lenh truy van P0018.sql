--load listBook
select [itemID], [itemName],
[author], [cateID], [quantity],
[imgUrl], [price],[dateOfCreate],
[description], [status]
from item
where quantity > 0 and [status] = 'Active'
go

--search item like by name
select [itemID], [itemName],
[author], [cateID], [quantity],
[imgUrl], [price],[dateOfCreate],
[description], [status]
from item
where quantity > 0 and [status] = 'Active'
and itemName like ?
go

--select item by cateID
select [itemID], [itemName],
[author], [cateID], [quantity],
[imgUrl], [price],[dateOfCreate],
[description], [status]
from item
where quantity > 0 and [status] = 'Active'
and cateID = ?
go

--select item by range of price
select [itemID], [itemName],
[author], [cateID], [quantity],
[imgUrl], [price],[dateOfCreate],
[description], [status]
from item
where quantity > 0 and [status] = 'Active'
and price between 500000 and 800000
go

-- create a new book
insert into item (itemID, itemName, 
author, cateID, quantity, imgUrl, 
price, dateOfCreate, [description], [status])
values ('BS100026','The Pragmatic Programmer','Andy Hunt, Dave Thomas','se','200',
'','700000','2021-06-13','','Active')
go

delete from item
where itemID = 'BS100026'
go

update item
set itemName = ?, author = ?,
cateID = ?, quantity = ?, imgUrl = ?,
price = ?, dateOfCreate = ?,
[description] = ?, [status] = ?
where itemID = ?
go

update item
set [status] = 'InActive'
where itemID = ?
go

select cateID, cateName
from category
go

--get cateID by Cate Name
select cateID
from category
where cateName = ?

--create discount 
insert into discount(discountID, discountName, 
rateDis, isUsing,dateOfCreate, userID)
values(?,?,?,?,?,?)
.go

--loadAllDis
select [discountID], [discountName], 
[rateDis], [isUsing], [dateOfCreate], 
[userID]
from discount
go

--create booking
insert into booking([bookingID],[userID],[dateOfCreate], [dateOfConfirm],
[discountID])

go

select top 1 *
from item
where quantity > 0 and [status] = 'Active'
order by dateOfCreate desc
go

select userID
from [user]
where roleID = 'user'
go

--add userID to DiscountID
update discount
set isAddAcc = 'True', userID = 'phucThai2601'
where discountID = 'dsc100001'
go

--load list discount by userID
select discountID, rateDis, isAddAcc, isUsing
from discount
where userID = 'phucThai2601'
go

--load discount by discountID
select discountID, rateDis, isAddAcc, isUsing
from discount
where discountID = 'dsc100001'
go

--create booking
insert into booking ([bookingID], [userID],
[fullname], [phone], [email], [address],
[dateOfCreate], [discountID], [paymentMethod], 
[subTotal], [shipping], 
[tax], [total], [status]) values (?,?,?,?,?,?,?,?,?,?,?
?,?,?)
go

insert into booking([bookingID], [userID],
[fullname], [phone], [email], [address],
[dateOfCreate], [discountID], [paymentMethod], 
[subTotal], [shipping], 
[tax], [total], [status]) values (?,?,?,?,?,?,?,?,?,?,?,
?,?,?)
go

--load history booking by userID
select [bookingID], [userID],
[fullname], [phone], [email], [address],
[dateOfCreate], [discountID], [paymentMethod], 
[subTotal], [shipping], 
[tax], [total], [status]
from booking
where userID = 'admin'
go

--check so luong item 
select quantity
from item
where itemID = 'BS100002'
go

--createBookingDe
insert into bookingDetails(bookingDeID, bookingID, itemID, itemName, imgUrl, quantity) values
(?,?,?,?,?,?)
go

insert into bookingDetails(bookingDeID, bookingID, itemID, itemName, imgUrl, quantity) values
('DSE133434','se01','BS100002','FDSF','SDFS',12)
go

--load list his details by bookid
select bookingDeID, bookingID, itemID, itemName, imgUrl, quantity
from bookingDetails
where bookingID = 'se01'
go

--load info by userID
select userID, fullname, phone, email, [address], roleID
from [user]
where userID = 'phucThai2601'
go

--update quan After checking out
update item
set quantity = quantity - ?
where itemID = ?
go

--update status discount after checking out
update discount
set isUsing = 1
where discountID = 'dsc100001'
go

--remove 