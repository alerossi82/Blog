USE [BLOG]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 21-Jan-17 7:03:21 PM ******/
DROP TABLE [dbo].[Users]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 21-Jan-17 7:03:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[enabled] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Users] ([username], [password], [enabled]) VALUES (N'Alessandro', N'aleprova', 1)
INSERT [dbo].[Users] ([username], [password], [enabled]) VALUES (N'Fabio', N'fabioprova', 1)
INSERT [dbo].[Users] ([username], [password], [enabled]) VALUES (N'Julie', N'julieprova', 1)
