use JavaWeFptAsmBanHangTet
GO
/* Cac thao tac bussiness voi Account*/	
select *
from Account
GO
select roleID
from Account where username ='phucdo2601' COLLATE SQL_Latin1_General_CP1_CS_AS  
and password = 'LongKH' COLLATE SQL_Latin1_General_CP1_CS_AS
go
select username, fullname, address, phone, email
from Account where roleID = 'user' and fullname like ?
go
update Account set fullname = ?, address = ?, phone =?, email=?
where username = ?
go
delete Account where username = ?
go
insert into Account(username, password, fullname, address, email, phone, roleID)
values(?,?,?,?,?,?,?)
go
/*
	findByPrimarykey -- de tim dc vi tri de cap nhat cua Account
*/
select fullname, address, phone, email
from Account where	username =?
go

/* Cac thao tac bussiness voi Category*/	
select *
from Category
go
select categoryID, categoryName, description
from Category where categoryID like '%%'
go
update Category set categoryName = ?, description = ?
where categoryID = ?
go
delete Category where categoryID = ? on delete
go
insert Category(categoryID, categoryName, description) 
values (?,?,?)
go
/*
	findByPrimarykey -- de tim dc vi tri de cap nhat cua Account
*/
select categoryName, description
from Category where categoryID = ?
go

/* Cac thao tac bussiness voi Product*/
select *
from Product	
go
update Product set categoryID = ?, productName = ?, image = ?, description =?, price = ?, quantity = ?, sale = ?
where productID = ?
go
delete Product where productID = ?
go
insert Product(productID, categoryID, productName, image, price, quantity, sale, description)
values (?,?,?,?,?,?,?,?)
go
/*
	findByPrimarykey -- de tim dc vi tri de cap nhat cua Product
*/
select categoryID, productName, image, description, price, quantity, sale
from Product where productID = ?
go

select productID, categoryID, productName, image,
description, price, quantity, sale, unit 
from Product where productID like '%%' 
go
update Product set categoryID = 'st01', productName = 'Bánh Danisa NK Loai 1',
 description =N'Bánh Nhập Khẩu', price = '450000', quantity = '2000', sale = '0', unit = N'Hộp'
 where productID = 'SP10000001'
 GO
 insert Product(productID,categoryID,productName,[image],price,quantity,sale,[description],dateOfPost)
values (?,?,?,?,?,?,?,?,?)
go


select productID, categoryID, productName, image, description, price, quantity, sale 
from Product where productID like '%%'

go
/*Cau lenh check dang nhap khi co them bien trang thai*/
select roleID from Account where username = ? 
COLLATE SQL_Latin1_General_CP1_CS_AS and password = ? 
COLLATE SQL_Latin1_General_CP1_CS_AS and status = ?
go

/*Cac cau lenh truy van voi Order*/
/*them mot order*/
insert [dbo].[Order] (orderID, username, customerName, addressSending, totalPrice, payment,dateOfBooking, waiting, finishing)
values (?,?,?,?,?,?,?,?,?)
go
/*findOrderLikeOrderID*/
select [orderID], [username], [customerName], [addressSending], [totalPrice], 
[dateOfBooking], [payment], [waiting], [finishing], [dateOfFinishing]
from [dbo].[Order]
where username like ?
go

/*Cap nhat lai so luong san pham cua Product*/
update Product set quantity = quantity - ?
where productID = ?
go

/*Cac cau lenh truy van OrderDetails*/
/*Insert OrderDetail */
insert OrderDetail (orderID, productID, productName, price, quantity) 
values (?,?,?,?,?) 
go

insert [dbo].[Order] (orderID, username, customerName, addressSending, totalPrice, payment,dateOfBooking, waiting, finishing)
values ('fsdfsdf','duongpham01','pham van duong','bac ninh','100000','Cash','2020-02-10',1,0)