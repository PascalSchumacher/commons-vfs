/*
 * Copyright 2003,2004 The Apache Software Foundation.
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
package org.apache.commons.vfs.provider.http;

import org.apache.commons.vfs.FileName;
import org.apache.commons.vfs.FileSystem;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.provider.AbstractOriginatingFileProvider;
import org.apache.commons.vfs.provider.GenericFileName;

/**
 * An HTTP provider that uses commons-httpclient.
 *
 * @author <a href="mailto:adammurdoch@apache.org">Adam Murdoch</a>
 * @version $Revision: 1.3 $ $Date: 2004/02/28 03:35:51 $
 */
public class HttpFileProvider
    extends AbstractOriginatingFileProvider
{
    /**
     * Parses an abolute URI.
     */
    protected FileName parseUri( final String uri )
        throws FileSystemException
    {
        return GenericFileName.parseUri( uri, 80 );
    }

    /**
     * Creates a {@link FileSystem}.
     */
    protected FileSystem doCreateFileSystem( final FileName rootName )
        throws FileSystemException
    {
        return new HttpFileSystem( (GenericFileName)rootName );
    }
}
