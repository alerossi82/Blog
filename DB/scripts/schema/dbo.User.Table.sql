USE [BLOG]
GO
/****** Object:  Table [dbo].[User]    Script Date: 07-Apr-16 8:48:55 PM ******/
DROP TABLE [dbo].[User]
GO
/****** Object:  Table [dbo].[User]    Script Date: 07-Apr-16 8:48:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Email] [nvarchar](max) NOT NULL,
	[Password] [nvarchar](50) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
