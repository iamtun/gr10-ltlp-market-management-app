USE master
CREATE DATABASE AppMarket
GO

USE [AppMarket]
GO
/****** Object:  Table [dbo].[accounts]    Script Date: 11/14/2022 4:55:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[accounts](
	[password] [varchar](255) NOT NULL,
	[username] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[order_details]    Script Date: 11/14/2022 4:55:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_details](
	[order_id] [int] NOT NULL,
	[product_id] [int] NOT NULL,
	[quantity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[order_id] ASC,
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[orders]    Script Date: 11/14/2022 4:55:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[orders](
	[order_id] [int] IDENTITY(1,1) NOT NULL,
	[order_date] [datetime2](6) NOT NULL,
	[staff_id] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[product_types]    Script Date: 11/14/2022 4:55:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product_types](
	[product_type_id] [int] IDENTITY(1,1) NOT NULL,
	[selling] [bit] NULL,
	[type_name] [nvarchar](255) NOT NULL,
	[unit] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[product_type_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[products]    Script Date: 11/14/2022 4:55:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[products](
	[product_id] [int] IDENTITY(1,1) NOT NULL,
	[selling] [bit] NULL,
	[name] [nvarchar](255) NOT NULL,
	[number] [int] NOT NULL,
	[price] [float] NOT NULL,
	[product_type_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[staffs]    Script Date: 11/14/2022 4:55:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[staffs](
	[staff_id] [varchar](255) NOT NULL,
	[address] [nvarchar](45) NOT NULL,
	[gender] [bit] NOT NULL,
	[identify] [nvarchar](45) NOT NULL,
	[name] [nvarchar](45) NOT NULL,
	[phone] [nvarchar](45) NOT NULL,
	[position] [bit] NOT NULL,
	[status] [bit] NOT NULL,
	[manager_id] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[staff_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[accounts] ([password], [username]) VALUES (N'123456', N'admin')
INSERT [dbo].[accounts] ([password], [username]) VALUES (N'123456', N'NV001')
INSERT [dbo].[accounts] ([password], [username]) VALUES (N'123456', N'NV002')
INSERT [dbo].[accounts] ([password], [username]) VALUES (N'123456', N'NV003')
INSERT [dbo].[accounts] ([password], [username]) VALUES (N'123456', N'NV004')
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (1, 1, 3)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (1, 2, 4)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (2, 2, 3)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (2, 3, 4)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (2, 20, 3)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (3, 6, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (3, 7, 8)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (4, 4, 3)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (4, 11, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (5, 3, 4)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (5, 8, 7)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (6, 1, 3)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (6, 2, 4)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (6, 5, 7)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (7, 11, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (7, 12, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (7, 13, 2)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (8, 4, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (8, 7, 8)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (8, 15, 5)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (9, 2, 4)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (9, 5, 7)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (10, 2, 5)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (10, 8, 7)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (11, 1, 7)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (11, 2, 5)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (11, 22, 4)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (11, 25, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (12, 1, 4)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (12, 6, 2)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (12, 8, 2)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (13, 7, 8)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (13, 8, 3)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (13, 9, 2)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (14, 17, 3)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (14, 18, 4)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (14, 22, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (15, 1, 5)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (15, 5, 7)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (15, 8, 4)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (16, 4, 3)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (16, 7, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (16, 10, 4)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (16, 15, 2)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (17, 3, 4)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (17, 6, 4)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (18, 4, 5)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (18, 5, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (18, 17, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (19, 23, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (19, 24, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (19, 25, 3)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (20, 2, 7)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (20, 6, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (20, 14, 5)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (21, 1, 3)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (21, 2, 3)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (21, 16, 3)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (22, 5, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (22, 12, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (22, 14, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (23, 4, 3)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (23, 21, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (23, 28, 3)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (24, 1, 3)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (24, 4, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (24, 8, 2)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (25, 1, 3)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (25, 2, 4)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (25, 5, 1)
INSERT [dbo].[order_details] ([order_id], [product_id], [quantity]) VALUES (25, 23, 3)
SET IDENTITY_INSERT [dbo].[orders] ON 

INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (1, CAST(N'2022-11-10 11:37:09.7730000' AS DateTime2), N'NV001')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (2, CAST(N'2022-11-10 11:37:46.5780000' AS DateTime2), N'NV001')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (3, CAST(N'2022-11-10 11:38:03.1220000' AS DateTime2), N'NV001')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (4, CAST(N'2022-11-10 11:38:17.3620000' AS DateTime2), N'NV001')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (5, CAST(N'2022-11-10 11:38:31.3220000' AS DateTime2), N'NV001')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (6, CAST(N'2022-11-11 11:43:28.1300000' AS DateTime2), N'NV003')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (7, CAST(N'2022-11-11 11:43:53.0060000' AS DateTime2), N'NV003')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (8, CAST(N'2022-11-11 11:44:15.4940000' AS DateTime2), N'NV003')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (9, CAST(N'2022-11-11 11:44:48.3030000' AS DateTime2), N'NV003')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (10, CAST(N'2022-11-11 11:45:10.1900000' AS DateTime2), N'NV003')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (11, CAST(N'2022-11-12 11:46:36.7050000' AS DateTime2), N'NV002')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (12, CAST(N'2022-11-12 11:47:30.2570000' AS DateTime2), N'NV002')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (13, CAST(N'2022-11-12 11:47:50.2410000' AS DateTime2), N'NV002')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (14, CAST(N'2022-11-12 11:48:10.9370000' AS DateTime2), N'NV002')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (15, CAST(N'2022-11-12 11:48:37.8330000' AS DateTime2), N'NV002')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (16, CAST(N'2022-11-13 16:01:17.6880000' AS DateTime2), N'NV002')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (17, CAST(N'2022-11-13 16:01:31.8720000' AS DateTime2), N'NV002')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (18, CAST(N'2022-11-13 16:01:54.1280000' AS DateTime2), N'NV002')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (19, CAST(N'2022-11-13 16:25:26.9950000' AS DateTime2), N'NV002')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (20, CAST(N'2022-11-13 16:25:43.8560000' AS DateTime2), N'NV002')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (21, CAST(N'2022-11-14 16:28:32.6790000' AS DateTime2), N'NV001')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (22, CAST(N'2022-11-14 16:28:48.9750000' AS DateTime2), N'NV001')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (23, CAST(N'2022-11-14 16:29:23.0310000' AS DateTime2), N'NV001')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (24, CAST(N'2022-11-14 16:30:23.0240000' AS DateTime2), N'NV001')
INSERT [dbo].[orders] ([order_id], [order_date], [staff_id]) VALUES (25, CAST(N'2022-11-14 16:35:08.8350000' AS DateTime2), N'NV002')
SET IDENTITY_INSERT [dbo].[orders] OFF
SET IDENTITY_INSERT [dbo].[product_types] ON 

INSERT [dbo].[product_types] ([product_type_id], [selling], [type_name], [unit]) VALUES (1, 1, N'Nước giải khát', N'Chai')
INSERT [dbo].[product_types] ([product_type_id], [selling], [type_name], [unit]) VALUES (2, 1, N'Snack', N'Bịch')
INSERT [dbo].[product_types] ([product_type_id], [selling], [type_name], [unit]) VALUES (3, 1, N'Hóa mỹ phẩm', N'Chai')
INSERT [dbo].[product_types] ([product_type_id], [selling], [type_name], [unit]) VALUES (4, 1, N'Thực phẩm khô', N'Gói')
INSERT [dbo].[product_types] ([product_type_id], [selling], [type_name], [unit]) VALUES (5, 1, N'Kem', N'Cái')
INSERT [dbo].[product_types] ([product_type_id], [selling], [type_name], [unit]) VALUES (6, 1, N'Bánh kẹo', N'Bịch')
INSERT [dbo].[product_types] ([product_type_id], [selling], [type_name], [unit]) VALUES (7, 1, N'Rượu', N'Chai')
INSERT [dbo].[product_types] ([product_type_id], [selling], [type_name], [unit]) VALUES (8, 1, N'Bia', N'Lon')
INSERT [dbo].[product_types] ([product_type_id], [selling], [type_name], [unit]) VALUES (9, 0, N'Bia', N'Thùng')
SET IDENTITY_INSERT [dbo].[product_types] OFF
SET IDENTITY_INSERT [dbo].[products] ON 

INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (1, 1, N'Sting', 969, 10000, 1)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (2, 1, N'Pepsi', 961, 10000, 1)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (3, 1, N'7Up', 988, 10000, 1)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (4, 1, N'C2', 984, 10000, 1)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (5, 1, N'Mirinda', 976, 10000, 1)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (6, 1, N'Oxi Cay', 992, 5000, 2)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (7, 1, N'Lays', 975, 5000, 2)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (8, 1, N'Ostar', 975, 5000, 2)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (9, 1, N'Oishi', 998, 5000, 2)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (10, 1, N'Bento', 996, 5000, 2)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (11, 1, N'Dove', 998, 50000, 3)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (12, 1, N'Clear', 998, 50000, 3)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (13, 1, N'Listerine', 998, 50000, 3)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (14, 1, N'Nivea', 994, 50000, 3)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (15, 1, N'P/S', 993, 50000, 3)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (16, 1, N'Hảo Hảo', 997, 4000, 4)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (17, 1, N'Nescafe', 996, 50000, 4)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (18, 1, N'Trà Lipton', 996, 5000, 4)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (19, 1, N'Kokomi', 1000, 5000, 4)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (20, 1, N'Omachi', 997, 5000, 4)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (21, 1, N'Melona', 999, 15000, 5)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (22, 1, N'Ốc quế', 995, 15000, 5)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (23, 1, N'Socola', 996, 15000, 5)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (24, 1, N'Kitkat', 999, 15000, 5)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (25, 1, N'Matcha', 996, 15000, 5)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (26, 1, N'Choco-Pie', 1000, 25000, 6)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (27, 1, N'Snickers', 1000, 25000, 6)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (28, 1, N'Oreo', 997, 25000, 6)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (29, 1, N'Trident', 1000, 25000, 6)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (30, 1, N'Xylitol', 1000, 25000, 6)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (31, 1, N'Chivas 18', 1000, 3000000, 7)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (32, 1, N'Chivas 12', 1000, 2500000, 7)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (33, 1, N'Chivas 21', 1000, 5000000, 7)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (34, 1, N'Chivas 25', 1000, 7500000, 7)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (35, 1, N'Chivas 32', 1000, 10000000, 7)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (36, 1, N'Tiger', 1000, 20000, 8)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (37, 1, N'Huda', 1000, 20000, 8)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (38, 1, N'Bia Saigon', 1000, 20000, 8)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (39, 1, N'333', 1000, 20000, 8)
INSERT [dbo].[products] ([product_id], [selling], [name], [number], [price], [product_type_id]) VALUES (40, 1, N'Hà Nội', 1000, 20000, 8)
SET IDENTITY_INSERT [dbo].[products] OFF
INSERT [dbo].[staffs] ([staff_id], [address], [gender], [identify], [name], [phone], [position], [status], [manager_id]) VALUES (N'admin', N'278 Quang Trung', 1, N'123456789', N'Bảo Trấn', N'0812345678', 1, 1, NULL)
INSERT [dbo].[staffs] ([staff_id], [address], [gender], [identify], [name], [phone], [position], [status], [manager_id]) VALUES (N'NV001', N'275 Quang Trung', 1, N'215543432', N'Lê Tuấn', N'0343220597', 0, 1, N'admin')
INSERT [dbo].[staffs] ([staff_id], [address], [gender], [identify], [name], [phone], [position], [status], [manager_id]) VALUES (N'NV002', N'188 Quang Trung', 1, N'123456781', N'Nguyễn Đức Huy', N'0343221557', 0, 1, N'admin')
INSERT [dbo].[staffs] ([staff_id], [address], [gender], [identify], [name], [phone], [position], [status], [manager_id]) VALUES (N'NV003', N'99 Quang Trung', 0, N'123456782', N'Võ Minh Phương', N'0343221234', 0, 1, N'admin')
INSERT [dbo].[staffs] ([staff_id], [address], [gender], [identify], [name], [phone], [position], [status], [manager_id]) VALUES (N'NV004', N'275 Bạch Đằng', 0, N'123456783', N'Nguyễn Thị Hồng Thơ', N'0357073335', 1, 1, N'admin')
SET ANSI_PADDING ON

GO
/****** Object:  Index [UK_m3lew9m4h05uyvffdvdp8769y]    Script Date: 11/14/2022 4:55:09 PM ******/
ALTER TABLE [dbo].[staffs] ADD  CONSTRAINT [UK_m3lew9m4h05uyvffdvdp8769y] UNIQUE NONCLUSTERED 
(
	[phone] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UK_sl0j1uc2n57qnjl5j336hms47]    Script Date: 11/14/2022 4:55:09 PM ******/
ALTER TABLE [dbo].[staffs] ADD  CONSTRAINT [UK_sl0j1uc2n57qnjl5j336hms47] UNIQUE NONCLUSTERED 
(
	[identify] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[accounts]  WITH CHECK ADD  CONSTRAINT [FKn1bwvemj999g70qod1w4k3dg1] FOREIGN KEY([username])
REFERENCES [dbo].[staffs] ([staff_id])
GO
ALTER TABLE [dbo].[accounts] CHECK CONSTRAINT [FKn1bwvemj999g70qod1w4k3dg1]
GO
ALTER TABLE [dbo].[order_details]  WITH CHECK ADD  CONSTRAINT [FK4q98utpd73imf4yhttm3w0eax] FOREIGN KEY([product_id])
REFERENCES [dbo].[products] ([product_id])
GO
ALTER TABLE [dbo].[order_details] CHECK CONSTRAINT [FK4q98utpd73imf4yhttm3w0eax]
GO
ALTER TABLE [dbo].[order_details]  WITH CHECK ADD  CONSTRAINT [FKjyu2qbqt8gnvno9oe9j2s2ldk] FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([order_id])
GO
ALTER TABLE [dbo].[order_details] CHECK CONSTRAINT [FKjyu2qbqt8gnvno9oe9j2s2ldk]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK7vt11rektq6d400j5r1ajw8st] FOREIGN KEY([staff_id])
REFERENCES [dbo].[staffs] ([staff_id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK7vt11rektq6d400j5r1ajw8st]
GO
ALTER TABLE [dbo].[products]  WITH CHECK ADD  CONSTRAINT [FKrv6og3b2qlahvka0bxn7btyqd] FOREIGN KEY([product_type_id])
REFERENCES [dbo].[product_types] ([product_type_id])
GO
ALTER TABLE [dbo].[products] CHECK CONSTRAINT [FKrv6og3b2qlahvka0bxn7btyqd]
GO
ALTER TABLE [dbo].[staffs]  WITH CHECK ADD  CONSTRAINT [FKefpdoo7xl4dp551s13w76pclk] FOREIGN KEY([manager_id])
REFERENCES [dbo].[staffs] ([staff_id])
GO
ALTER TABLE [dbo].[staffs] CHECK CONSTRAINT [FKefpdoo7xl4dp551s13w76pclk]
GO
/****** Object:  Trigger [dbo].[trg_recall]    Script Date: 11/14/2022 4:55:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create trigger [dbo].[trg_recall] on [dbo].[order_details]
for delete as
begin
	update products
	set number = number + (select quantity from deleted)
	where product_id = (select product_id from deleted)
end


GO
/****** Object:  Trigger [dbo].[trg_sell]    Script Date: 11/14/2022 4:55:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create trigger [dbo].[trg_sell] on [dbo].[order_details]
after insert as
begin
	update products
	set number = number - (
		select quantity from inserted
	)
	where product_id = (select product_id from inserted)
end


GO
/****** Object:  Trigger [dbo].[trg_update]    Script Date: 11/14/2022 4:55:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create trigger [dbo].[trg_update] on [dbo].[order_details]
after update as
begin
	update products
	set  number = number - (select quantity from inserted) + (select quantity from deleted)
	where product_id = (select product_id from deleted)
end


GO
