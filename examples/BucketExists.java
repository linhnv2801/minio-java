/*
 * MinIO Java SDK for Amazon S3 Compatible Cloud Storage, (C) 2015 MinIO, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import io.minio.BucketExistsArgs;
import io.minio.MinioClient;
import io.minio.errors.MinioException;

public class BucketExists {
	/** MinioClient.bucketExists() example. */
	public static void main(String[] args)
			throws IOException, NoSuchAlgorithmException, InvalidKeyException {
		try {
			/* play.min.io for test and development. */
			MinioClient minioClient = MinioClient.builder()
					.endpoint("http://100.65.238.55:9098")
					.credentials("root", "UkN8Mm2Y76tMZMQ3")
					.build();

			/* Amazon S3: */
			// MinioClient minioClient =
			// MinioClient.builder()
			// .endpoint("https://s3.amazonaws.com")
			// .credentials("YOUR-ACCESSKEY", "YOUR-SECRETACCESSKEY")
			// .build();

			// Check whether 'my-bucketname' exist or not.
			boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket("my-bucketname").build());
			if (found) {
				System.out.println("my-bucketname exists");
			} else {
				System.out.println("my-bucketname does not exist");
			}
		} catch (MinioException e) {
			System.out.println("Error occurred: " + e);
		}
	}
}
