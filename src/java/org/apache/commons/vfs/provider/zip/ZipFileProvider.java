/*
 * Copyright 2002, 2003,2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.vfs.provider.zip;

import org.apache.commons.vfs.FileName;
import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystem;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.provider.AbstractLayeredFileProvider;
import org.apache.commons.vfs.provider.FileProvider;

/**
 * A file system provider for Zip files.  Provides read-only file systems.
 *
 * @author <a href="mailto:adammurdoch@apache.org">Adam Murdoch</a>
 * @version $Revision: 1.3 $ $Date: 2004/02/28 03:35:52 $
 */
public class ZipFileProvider
    extends AbstractLayeredFileProvider
    implements FileProvider
{
    /**
     * Parses an absolute URI.
     * @param uri The URI to parse.
     */
    protected FileName parseUri( final String uri )
        throws FileSystemException
    {
        return ZipFileName.parseUri( uri );
    }

    /**
     * Creates a layered file system.  This method is called if the file system
     * is not cached.
     * @param scheme The URI scheme.
     * @param file The file to create the file system on top of.
     * @return The file system.
     */
    protected FileSystem doCreateFileSystem( final String scheme,
                                             final FileObject file )
        throws FileSystemException
    {
        final FileName rootName =
            new ZipFileName( scheme, file.getName().getURI(), FileName.ROOT_PATH );
        return new ZipFileSystem( rootName, file );
    }
}
