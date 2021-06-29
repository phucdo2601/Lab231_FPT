USE [master]
GO
/****** Object:  Database [JavaWeFptAsmBanHangTet]    Script Date: 2/17/2021 8:53:35 PM ******/
CREATE DATABASE [JavaWeFptAsmBanHangTet]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'JavaWeFptAsmBanHangTet', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SE140354\MSSQL\DATA\JavaWeFptAsmBanHangTet.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'JavaWeFptAsmBanHangTet_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SE140354\MSSQL\DATA\JavaWeFptAsmBanHangTet_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [JavaWeFptAsmBanHangTet].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET ARITHABORT OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET  DISABLE_BROKER 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET RECOVERY FULL 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET  MULTI_USER 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET DB_CHAINING OFF 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'JavaWeFptAsmBanHangTet', N'ON'
GO
USE [JavaWeFptAsmBanHangTet]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 2/17/2021 8:53:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Account](
	[username] [varchar](200) NOT NULL,
	[password] [varchar](200) NULL,
	[fullname] [varchar](200) NULL,
	[address] [nvarchar](200) NULL,
	[phone] [varchar](200) NULL,
	[email] [varchar](200) NULL,
	[roleID] [nvarchar](200) NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Category]    Script Date: 2/17/2021 8:53:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Category](
	[categoryID] [varchar](200) NOT NULL,
	[categoryName] [varchar](200) NULL,
	[description] [varchar](max) NULL,
	[dateOfPost] [datetime] NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Order]    Script Date: 2/17/2021 8:53:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Order](
	[orderID] [varchar](100) NOT NULL,
	[username] [varchar](200) NULL,
	[addressSending] [nvarchar](500) NULL,
	[dateOfBooking] [datetime] NULL,
	[payment] [varchar](250) NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 2/17/2021 8:53:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[orderID] [varchar](100) NOT NULL,
	[productID] [varchar](250) NOT NULL,
	[productName] [varchar](300) NULL,
	[quantity] [int] NULL,
	[price] [float] NULL,
	[sale] [int] NULL,
	[historyOrder] [datetime] NULL,
 CONSTRAINT [PK_OrderDetail_1] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC,
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Product]    Script Date: 2/17/2021 8:53:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Product](
	[productID] [varchar](250) NOT NULL,
	[categoryID] [varchar](200) NULL,
	[productName] [nvarchar](300) NULL,
	[image] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL,
	[price] [float] NULL,
	[unit] [nvarchar](max) NULL,
	[quantity] [int] NULL,
	[sale] [int] NULL,
	[dateOfPost] [datetime] NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Account] ([username], [password], [fullname], [address], [phone], [email], [roleID], [status]) VALUES (N'admin', N'1', NULL, NULL, NULL, NULL, N'admin', 1)
INSERT [dbo].[Account] ([username], [password], [fullname], [address], [phone], [email], [roleID], [status]) VALUES (N'dungtran0408', N'A@1234', N'Tran Thi Thuy Dung', N'', N'', N'', N'user', 1)
INSERT [dbo].[Account] ([username], [password], [fullname], [address], [phone], [email], [roleID], [status]) VALUES (N'duongpham01', N'A@1234', N'Pham Binh Duong', N'Nam Ð?nh', N'6786798679', N'binhduong@gmail.com', N'user', 1)
INSERT [dbo].[Account] ([username], [password], [fullname], [address], [phone], [email], [roleID], [status]) VALUES (N'duongpham2502', N'DuongAS', N'Pham Van Duong', N'Nam Dinh', NULL, N'duongpham2502@gmail.com', N'user', 1)
INSERT [dbo].[Account] ([username], [password], [fullname], [address], [phone], [email], [roleID], [status]) VALUES (N'lantran1506', N'123$RT', N'Tran Thanh Lan', N'Cu Chi', NULL, N'lantran1506', N'user', 1)
INSERT [dbo].[Account] ([username], [password], [fullname], [address], [phone], [email], [roleID], [status]) VALUES (N'liemnguyen1504', N'Liem@123', N'Nguyen Thanh Liem', N'Tien Giang', N'6465765867', N'liemNguyen2504@gmail.com', N'user', 1)
INSERT [dbo].[Account] ([username], [password], [fullname], [address], [phone], [email], [roleID], [status]) VALUES (N'longpham123', N'A@123', N'Pham Thanh Long', N'Bien Hoa', NULL, N'longpham123@gmail.com', N'user', 1)
INSERT [dbo].[Account] ([username], [password], [fullname], [address], [phone], [email], [roleID], [status]) VALUES (N'namthanh0403', NULL, N'Do Ngoc Khang', N'HA Noi', NULL, N'khangdo2506@gmail.com', N'user', 1)
INSERT [dbo].[Account] ([username], [password], [fullname], [address], [phone], [email], [roleID], [status]) VALUES (N'ngapham2702', N'Nga$1234', N'Pham Yen Nga ', N'Tay ninh', N'5346456564', N'ngapham2702@gmail.com', N'user', 1)
INSERT [dbo].[Account] ([username], [password], [fullname], [address], [phone], [email], [roleID], [status]) VALUES (N'phucdo2601', N'LongKH', N'Do Ngoc Phuc', N'Binh Thanh, Ho Chi Minh', NULL, N'phucdo2601@gmail.com', N'user', 1)
INSERT [dbo].[Account] ([username], [password], [fullname], [address], [phone], [email], [roleID], [status]) VALUES (N'thailai1234', N'A@1234', N'Lai Nguyen Quoc Thai', N'', N'', N'', N'user', 1)
INSERT [dbo].[Account] ([username], [password], [fullname], [address], [phone], [email], [roleID], [status]) VALUES (N'thinhnguyen2304', N'%^123Aer', N'Nguyen Phu Thinh ', N'Rach Gia', N'5346455475', N'thinhnguyen2604@gmail.com', N'user', 0)
INSERT [dbo].[Category] ([categoryID], [categoryName], [description], [dateOfPost], [status]) VALUES (N'st01', N'banh nk', N'banh nhap khau Loai 1', CAST(N'2020-05-31 22:09:37.480' AS DateTime), 1)
INSERT [dbo].[Category] ([categoryID], [categoryName], [description], [dateOfPost], [status]) VALUES (N'st02', N'keo', N'cac loai keo', CAST(N'2020-05-30 22:09:37.480' AS DateTime), 1)
INSERT [dbo].[Category] ([categoryID], [categoryName], [description], [dateOfPost], [status]) VALUES (N'st03', N'mut', N'cac loai mut', CAST(N'2020-05-29 22:09:37.480' AS DateTime), 1)
INSERT [dbo].[Category] ([categoryID], [categoryName], [description], [dateOfPost], [status]) VALUES (N'st04', N'thuc uong khong con', N'thuc uong co hai cho suc khoe', CAST(N'2020-05-28 22:09:37.480' AS DateTime), 1)
INSERT [dbo].[Category] ([categoryID], [categoryName], [description], [dateOfPost], [status]) VALUES (N'st05', N'thuc uong co con', NULL, CAST(N'2020-05-27 22:09:37.480' AS DateTime), 1)
INSERT [dbo].[Category] ([categoryID], [categoryName], [description], [dateOfPost], [status]) VALUES (N'st06', N'luong thuc chinh', NULL, CAST(N'2020-05-26 22:09:37.480' AS DateTime), 1)
INSERT [dbo].[Category] ([categoryID], [categoryName], [description], [dateOfPost], [status]) VALUES (N'st07', N'thuc pham che bien ', N'cac loai thuc an dac trung ngay tet', CAST(N'2020-05-25 22:09:37.480' AS DateTime), 1)
INSERT [dbo].[Category] ([categoryID], [categoryName], [description], [dateOfPost], [status]) VALUES (N'st08', N'thuc am dinh duong', N'hang noi dia nhat', CAST(N'2020-05-24 22:09:37.480' AS DateTime), 1)
INSERT [dbo].[Category] ([categoryID], [categoryName], [description], [dateOfPost], [status]) VALUES (N'st09', N'Hat say', NULL, CAST(N'2020-05-23 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000001', N'st01', N'Bánh Danisa NK Loai 1', N'https://i2.wp.com/banhkeogiare.com/wp-content/uploads/2019/10/3-5.jpg', N'Bánh Nhập Khẩu Loaij1', 450000, N'Hộp', 2000, 0, CAST(N'2021-02-05 22:09:37.480' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000002', N'st01', N'Bánh Oreo NK', N'https://ptaste.vn/wp-content/uploads/2019/12/banh-oreo-nhan-vani.jpg', N'Banh Nhap Khau', 400000, N'Hop', 2000, 0, CAST(N'2021-02-04 22:09:37.480' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000003', N'st01', N'Banh Socola hon hop Roca', N'https://www.vitaminhouse.vn/data/ck/images/Top%205%20lo%E1%BA%A1i%20b%C3%A1nh%20k%E1%BA%B9o%20nh%E1%BA%ADp%20kh%E1%BA%A9u%20t%E1%BB%AB%20M%E1%BB%B9%20%C4%91ang%20c%E1%BB%B1c%20hot%20-%203.png', N'Banh Nhap Khau', 600000, N'Thanh', 3000, 0, CAST(N'2021-02-03 22:09:37.480' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000004', N'st02', N'Socola Almondrush', N'https://salt.tikicdn.com/cache/w1200/ts/product/dc/f7/30/0f7ac28ee69af23ec5e5aa21cb33ba22.jpg', N'Keo Nhap Khau', 150000, N'Thanh', 5000, 12, CAST(N'2021-02-02 22:09:37.480' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000005', N'st02', N'Socola M&M America', N'https://bachhoacc.com/wp-content/uploads/2020/03/socola-nhan-dau-phong-m-m-my-2.jpg', N'Keo Nhap Khau', 450000, N'Hop', 6000, 0, CAST(N'2021-02-01 22:09:37.480' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000006', N'st01', N'Socola Hershey', N'https://www.hangngoainhap.com.vn/images/201812/goods_img/1048-p2-1545302282.jpg', N'Keo Nhap Khau', 180000, N'Goi', 5000, 0, CAST(N'2021-01-31 22:09:37.480' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000007', N'st02', N'Anthon Berg', N'https://ruouthuonghieu.com/wp-content/uploads/2018/12/B%C3%A1nh-K%E1%BA%B9o-T%E1%BA%BFt-2020_5.jpg', N'Keo Nhap Khau', 790000, N'Hop ', 6000, 0, CAST(N'2020-12-20 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000008', N'st08', N'Cafe Nestle Coffee Mate Original 1kg', N'https://cf.shopee.vn/file/bebb7cc630289ad75c696a5c1008c53c', N'Thuc uong dinh duong nhap khau', 300000, N'Hop', 5000, 0, CAST(N'2020-11-24 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000009', N'st09', N'Hạt Hạnh Nhân Sấy ', N'https://cf.shopee.vn/file/b4d2f4718c495a27d45adea119867428', N'Thuc pham dinh duong', 180000, N'Lo', 5000, 0, CAST(N'2020-10-21 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000010', N'st01', N'BÁNH GRAN PANETTONE MADI 1KG', N'https://cf.shopee.vn/file/5bb787081d06dd9c3b92bfca31f2ea9d', N'Banh Nhap Khau', 300000, N'Hop', 5000, 0, CAST(N'2020-10-20 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000011', N'st06', N'Thit hot my cao cấp Dak Premium Ham 454g', N'https://cf.shopee.vn/file/5bb48cf87369749f8477ff32255ba190', N'Thit hot nhap khau', 180000, N'Hop', 6000, 0, CAST(N'2020-10-19 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000012', N'st01', N'Jules Destrooper - Butter Waffles ', N'https://richmedia.ca-richimage.com/ImageDelivery/imageService?profileId=12026539&id=1881145&recipeId=500', N'Banh Nhap Khau', 500000, N'Hop', 6000, 0, CAST(N'2020-10-19 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000013', N'st01', N'European Cookies', N'https://www.vitaminhouse.vn/data/ck/images/10(5).jpg', N'Banh Nhap Khau', 500000, N'Hop', 6000, 0, CAST(N'2020-10-19 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000014', N'st01', N'Bánh ăn kiêng Crown Canape Party With … 280g', N'https://cf.shopee.vn/file/729998633606813de059765851f4ec51', N'Banh Nhap Khau', 80000, N'Hop', 5000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000015', N'st01', N'Bánh Banana Charlteok pie Queen Bin 310g', N'https://cf.shopee.vn/file/f02b36cd7f0dcf16db051de56044a641', N'Banh Nhap Khau', 65000, N'Hop ', 6000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000016', N'st01', N'Bánh Choco Charlteok pie Queen Bin Hàn Quốc 310g', N'https://cf.shopee.vn/file/29b30bfdb2f242943caba74d76cd2062', N'Banh Nhap Khau ', 65000, N'Hop', 6000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000017', N'st01', N'Bánh ChocoStar X5 Peanut Crunch Bar 648g', N'http://media3.scdn.vn/img2/2018/3_2/7SQSPU_simg_de2fe0_900x900_maxb.jpg', N'Banh Nhap Khau', 180000, N'Hop', 6000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000018', N'st02', N'Belgian Chocolate', N'https://cf.shopee.vn/file/b2c2b66d34e8f3df2e3cb803ffe8fedb', N'Keo Nhap Khau', 400000, N'Hop', 6000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000019', N'st01', N'Bánh Le Biscuit Francais Assortment Palets Galettes 720g ( Hộp màu vàng )', N'https://foodplaza.com.vn/wp-content/uploads/2020/07/11-banh-le-biscuit-francais-assortment-palets-galettes-720g-hop-mau-do-1.jpg', N'Banh Nhap Khau', 430000, N'Hop ', 6000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000020', N'st01', N'Banh mochi dau do', N'https://img.websosanh.vn/v2/users/root_product/images/banh-mocchi-nhan-dau-do/g0ibumcwhywoh.jpg', N'Bánh Nhập Khẩu', 55000, N'Hop', 6000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000021', N'st01', N'Bánh quế Sô cô la hạt dẻ Pepperigde Farm 382g', N'https://salt.tikicdn.com/cache/w1200/ts/product/86/07/be/ab3028329a36a97c70a568e7a34c203f.jpg', N'Banh Nhap Khau', 110000, N'Hop', 7000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000022', N'st01', N'Mc Vitie''s', N'https://kphucsinh.s3.ap-southeast-1.amazonaws.com/Contents/S%E1%BA%A3n%20ph%E1%BA%A9m%20%C3%82n%20Nam%202020/F143921-McVitie_s%20Digestive%20Milk%20Chocolate%20200g.jpg', N'Banh Nhap Khau', 120000, N'Hop ', 6000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000023', N'st03', N'Mứt Bonne Maman Cam đắng Bitter Orange 30g (Pháp)', N'https://cf.shopee.vn/file/6859dad384d0a640941e6a4dc21628ac', N'Mut Nhap Khau', 20000, N'Lo', 7000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000024', N'st03', N'Mứt ca cao hạt dẻ Nutela (Úc) - 200g', N'https://product.hstatic.net/1000126467/product/02965468.jpg', N'Mut Nhap Khau', 80000, N'Lo', 6000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000025', N'st05', N'Bia sứ St. Paul Triple 7,6% Bỉ – chai 500ml', N'https://i0.wp.com/shopruou247.com/wp-content/uploads/2019/04/Bia-s%E1%BB%A9-ST.-Paul-Triple-7.6-500-ml-3-min.jpg?resize=1020%2C1020', N'Bia Ruou Nhap Khau', 230000, N'Chai', 5000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000026', N'st05', N'Bia Chimay xanh 9% Bỉ – chai 330ml', N'https://product.hstatic.net/1000377007/product/u_172b5860c5b44a468b61d7baeeff721b.jpg', N'Bia Ruou Nhap Khau', 70000, N'Chai', 5000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000027', N'st05', N'Bia La Trappe Trappist Blond 6% Hà Lan – chai 330ml', N'https://i1.wp.com/shopruou247.com/wp-content/uploads/2019/05/Bia-La-Trappe-Blond-6-1-min.jpg?resize=1020%2C1020', N'Bia Ruou Nhap Khau', 80000, N'Chai', 5000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000028', N'st05', N'Bia Oranjeboom Premium Strong 18% Hà Lan – 24 lon 500ml', N'https://douongnhapkhau.com/wp-content/uploads/2020/01/bia-oranjeboom-extreme-strong-18-lon-500-ml.jpg', N'Bia Ruou Nhap Khau', 1050000, N'Thung', 1000, 0, CAST(N'2000-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000029', N'st04', N'Coca Nhật Chai Nhôm Lùn Nắp Vặn thùng 24', N'https://cf.shopee.vn/file/4596dec6609cc38243ed8b185c71942d', N'Nuoc uong khong con Nhap Khau', 760000, N'Thung', 2000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000030', N'st04', N'Nước ép Bundaberg Creaming Soda 375ml', N'https://cf.shopee.vn/file/60ac4c748178fa6888d41457bbc784f0', N'Nuoc uong khong con Nhap Khau', 50000, N'Chai', 10000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000031', N'st04', N'Nước ép táo HQ 180ml', N'https://cf.shopee.vn/file/1e919c78587b8895648db50c2267fcc2', N'Nuoc uong khong con Nhap Khau', 23000, N'Chai', 10000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000032', N'st04', N'Nước Ngọt Xá Xị A&W Mỹ', N'https://www.vitaminhouse.vn/data/bt4/nuoc-ngot-xa-xi-a-w-my-1567590495.jpg', N'Nuoc uong khong con Nhap Khau', 28000, N'Lon', 10000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000033', N'st04', N'Soda Welchs nho 355ml', N'https://bucket.nhanh.vn/store1/57095/ps/20191115/67d3184fd0a940029269c80dc6ee84df_600x600.jpg', N'Nuoc uong khong con Nhap Khau', 28000, N'Lon', 10000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000034', N'st04', N'Nước ép việt quất HQ 180ml', N'https://cf.shopee.vn/file/26e200253a5c85282c2ebf48f7ef56ca', N'Nuoc uong khong con Nhap Khau', 22000, N'Chai', 10000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000035', N'st04', N'Nước ép nha đam HQ 1L5', N'https://bizweb.dktcdn.net/thumb/1024x1024/100/361/770/products/nuoc-nha-dam-1500ml-han-quoc.jpg?v=1570677137787', N'Nuoc uong khong con Nhap Khau', 80000, N'Chai', 10000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000036', N'st08', N'DẦU RÁN OLIVE NGUYÊN CHẤT HANOLI 1000ML', N'https://cf.shopee.vn/file/928bfbfb846c189034ee4ed25ad1ff25', NULL, 190000, N'Chai', 2000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000037', N'st02', N'MẬN SẤY KHÔ SUNSWEET 1.59KG ', N'https://hangtieudungmy.com.vn/image/cache/catalog/153-800x800.jpg', NULL, 420000, N'Goi', 3000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000038', N'st07', N'KHÔ BÒ MỸ JACK LINK''S 92G', N'https://www.hangngoainhap.com.vn/images/201801/goods_img/2101_P_1515911206390.jpg', NULL, 170000, N'Goi', 4000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000039', N'st07', N'PATE GAN HEO 32% HENAFF 130G', N'https://cdn.concung.com/2020/02/44414-56926-large_mobile/pate-gan-heo-32-henaff-130g.jpg', NULL, 60000, N'Lon', 4000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000040', N'st07', N'PATE GÀ TÂY HENAFF 140G', N'https://cdn.concung.com/2020/02/44415-56922-large_mobile/pate-ga-tay-henaff-140g.jpg', NULL, 70000, N'Lon', 3000, 0, CAST(N'2020-10-18 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000041', N'st07', N'Trái cây đóng hộp Dole vị Đào ', N'https://dp84mqgv78zql.cloudfront.net/large_1577333803761.2688.jpg', NULL, 85000, N'Lon', 4000, 0, CAST(N'2020-10-17 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000042', N'st07', N' COCKTAIL LYCHEE IN SYRUP A CHOICE 565G', N'https://media3.scdn.vn/img4/2020/04_07/rQZ3AcxunVEIyjFxnfbE_simg_b5529c_800x800_maxb.jpg', N'', 85000, N'Lon', 4000, 0, CAST(N'2021-02-17 14:55:44.630' AS DateTime), 1)
INSERT [dbo].[Product] ([productID], [categoryID], [productName], [image], [description], [price], [unit], [quantity], [sale], [dateOfPost], [status]) VALUES (N'SP10000043', N'st07', N'Cocktail đóng hộp', N'https://lh3.googleusercontent.com/proxy/gpUUkOtLVX9dLfAWNSxE1gpGZN5mN8WaifZFry2-RSWtw5r487ArBaUhLQvDDXWNYyh1GaEbdYr4QlnI7CwBxCqnreMXgYjTElMH13gJ', N'', 180000, N'Hộp', 4500, 0, CAST(N'2021-02-17 00:00:00.000' AS DateTime), 1)
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Account] FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Account]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Order] FOREIGN KEY([orderID])
REFERENCES [dbo].[Order] ([orderID])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Order]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Product] FOREIGN KEY([productID])
REFERENCES [dbo].[Product] ([productID])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Product]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([categoryID])
REFERENCES [dbo].[Category] ([categoryID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category]
GO
USE [master]
GO
ALTER DATABASE [JavaWeFptAsmBanHangTet] SET  READ_WRITE 
GO
