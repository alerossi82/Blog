USE [BLOG]
GO
/****** Object:  Table [dbo].[Prezzo]    Script Date: 07-Apr-16 8:48:55 PM ******/
DROP TABLE [dbo].[Prezzo]
GO
/****** Object:  Table [dbo].[Prezzo]    Script Date: 07-Apr-16 8:48:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Prezzo](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Nome] [nvarchar](50) NULL
) ON [PRIMARY]

GO
