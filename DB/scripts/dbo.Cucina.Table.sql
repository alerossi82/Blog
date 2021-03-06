USE [BLOG]
GO
/****** Object:  Table [dbo].[Cucina]    Script Date: 21-Jan-17 7:03:21 PM ******/
DROP TABLE [dbo].[Cucina]
GO
/****** Object:  Table [dbo].[Cucina]    Script Date: 21-Jan-17 7:03:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cucina](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Nome] [nvarchar](max) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Cucina] ON 

INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (1, N'Cinese')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (2, N'Czech')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (3, N'Greek')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (4, N'Indian')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (5, N'International')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (6, N'Italian')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (7, N'Mexican')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (8, N'Steakhouse')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (9, N'Sushi')
SET IDENTITY_INSERT [dbo].[Cucina] OFF
