package ro.usv.rf;

public class MainClass {
	
	
	public static void main(String[] args) {
		String[][] learningSet;
		
		try {
			learningSet = FileUtils.readLearningSetFromFile("data.csv");
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;
			System.out.println(String.format("The learning set has %s patterns and %s features", numberOfPatterns, numberOfFeatures));
			double[][] initCoord=new double[3][2];
			initCoord[0][0]=23.27;	

			initCoord[0][1]=44.49;
			initCoord[1][0]=24;
			initCoord[1][1]=45.15;
			initCoord[2][0]=25.33;
			initCoord[2][1]=45.44;
		/*	for(int i=0; i<=numberOfPatterns;i++) {
				for(int j=0; j<numberOfFeatures;j++)
				{
					//System.out.print(learningSet[i][j]+" ");
				}
				//System.out.println();
			}*/
			
			int[] kn_cases ={9, 11, 17, 31};
			double[][] distance_array = new double[initCoord.length][learningSet.length];

			for(int i = 0; i < numberOfPatterns; i++)
			{
				for (int j = 0; j < initCoord.length; j++)
				{
					distance_array[j][i] = DistanceUtils.calculateDistanceEuclidianGeneralizedString(initCoord[j], learningSet[i]);
				}
			}
			String first_set = null;
			for(int i=0; i < kn_cases.length; i++)
			{
				first_set = DistanceUtils.calculateKNN(kn_cases[i], distance_array[0], learningSet);
				System.out.println("First set,  k =  " + kn_cases[i] + " has class: " + first_set); 
			}
			System.out.println();
			
			for(int i=0; i < kn_cases.length; i++)
			{
				first_set = DistanceUtils.calculateKNN(kn_cases[i], distance_array[1], learningSet);
				System.out.println("Second set,  k =  " + kn_cases[i] + " has class: " + first_set); 
			}
			
			System.out.println();
			for(int i=0; i < kn_cases.length; i++)
			{
				first_set = DistanceUtils.calculateKNN(kn_cases[i], distance_array[2], learningSet);
				System.out.println("Third set, k = " + kn_cases[i] + " has class: " + first_set); 
			}
			
			System.out.println("Done"); 
			
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}

}
